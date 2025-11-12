package lat.pam.droidcafeirsyad

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
// 1. IMPORT BottomNavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView

class ConfirmationFragment : Fragment(R.layout.fragment_confirmation) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvHalo: TextView = view.findViewById(R.id.tv_halo)
        val btnSelesai: Button = view.findViewById(R.id.btn_selesai)

        // Ambil nama yang dikirim dari AddressFragment
        val nama = arguments?.getString(EXTRA_NAME)
        tvHalo.text = "Halo ${nama ?: "Pelanggan"}," // Tampilkan nama

        btnSelesai.setOnClickListener {
            // Kembali ke Home
            navigateToHome()
        }
    }

    private fun navigateToHome() {
        // Hapus semua riwayat navigasi (OrderFragment, AddressFragment)
        parentFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        // Tampilkan HomeFragment
        parentFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, HomeFragment())
            .commit()

        // 2. TAMBAHKAN INI:
        // Dapatkan BottomNavigationView dari Activity dan set item terpilih
        activity?.findViewById<BottomNavigationView>(R.id.bottom_navigation)?.selectedItemId = R.id.home
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
    }
}