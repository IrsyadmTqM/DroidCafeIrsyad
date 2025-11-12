package lat.pam.droidcafeirsyad

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {

    // (Internal) Daftar pesanan yang bisa diubah di dalam ViewModel ini
    private val _orderList = MutableLiveData<ArrayList<Hero>>(arrayListOf())

    // (Eksternal) Daftar pesanan yang hanya bisa "dilihat" oleh Fragment
    // Ini yang akan diobservasi
    val orderList: LiveData<ArrayList<Hero>> = _orderList

    // Fungsi untuk menambah item ke daftar pesanan
    fun addOrder(hero: Hero) {
        // Ambil daftar yang ada saat ini
        val currentList = _orderList.value ?: arrayListOf()
        // Tambahkan item baru
        currentList.add(hero)
        // Setel nilainya lagi agar memicu observer
        _orderList.value = currentList
    }

    fun clearOrder() {
        _orderList.value = arrayListOf() // Setel kembali ke daftar kosong
    }
}