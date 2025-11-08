package lat.pam.droidcafeirsyad

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class OrderFragment : Fragment(R.layout.fragment_order) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Di sini kamu bisa setup tampilan setelah fragment diload
        // Contoh: inisialisasi RecyclerView, tombol, dsb.

        // contoh sederhana (nanti kamu ubah sesuai kebutuhan)
        // val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewOrder)
        // recyclerView.adapter = OrderAdapter(daftarPesanan)
    }
}
