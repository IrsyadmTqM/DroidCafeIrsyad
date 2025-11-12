package lat.pam.droidcafeirsyad

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels // <-- IMPORT
import com.google.android.material.textfield.TextInputEditText // <-- IMPORT

class AddressFragment : Fragment(R.layout.fragment_address) {

    // Dapatkan ViewModel
    private val orderViewModel: OrderViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnOrderKirim: Button = view.findViewById(R.id.btn_order_dan_kirim)
        val etNama: TextInputEditText = view.findViewById(R.id.et_nama) // Ambil EditText nama

        btnOrderKirim.setOnClickListener {
            // 1. Ambil nama dari EditText
            val namaLengkap = etNama.text.toString()

            // 2. Kosongkan data pesanan di ViewModel
            orderViewModel.clearOrder()

            // 3. Pindah ke ConfirmationFragment sambil kirim data nama
            navigateToConfirmation(namaLengkap)
        }
    }

    private fun navigateToConfirmation(nama: String) {
        val confirmationFragment = ConfirmationFragment()

        // Buat Bundle untuk kirim data
        val bundle = Bundle()
        bundle.putString(ConfirmationFragment.EXTRA_NAME, nama)
        confirmationFragment.arguments = bundle

        // Lakukan transaksi fragment
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout, confirmationFragment)
            // Kita tidak perlu addToBackStack di sini,
            // karena kita tidak ingin pengguna kembali ke halaman alamat
            commit()
        }
    }
}