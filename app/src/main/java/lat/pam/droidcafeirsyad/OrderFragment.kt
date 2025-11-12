package lat.pam.droidcafeirsyad

import android.os.Bundle
import android.view.View
import android.widget.Button // <-- IMPORT INI
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OrderFragment : Fragment(R.layout.fragment_order) {

    private val orderViewModel: OrderViewModel by activityViewModels()
    private lateinit var rvOrder: RecyclerView
    private lateinit var orderAdapter: ListHeroAdapter
    private val currentOrderList = ArrayList<Hero>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Setup RecyclerView
        rvOrder = view.findViewById(R.id.rv_order)
        rvOrder.layoutManager = LinearLayoutManager(requireContext())

        // 2. Setup Adapter
        orderAdapter = ListHeroAdapter(currentOrderList)
        rvOrder.adapter = orderAdapter

        // 3. Amati Perubahan Data
        orderViewModel.orderList.observe(viewLifecycleOwner) { newList ->
            currentOrderList.clear()
            currentOrderList.addAll(newList)
            orderAdapter.notifyDataSetChanged()
        }

        // 4. TAMBAHAN: Setup Tombol Kirim
        val btnKirim: Button = view.findViewById(R.id.btn_kirim)
        btnKirim.setOnClickListener {
            navigateToAddress()
        }
    }

    private fun navigateToAddress() {
        val addressFragment = AddressFragment()
        val fragmentManager = parentFragmentManager

        fragmentManager.beginTransaction().apply {
            // GANTI DENGAN ID INI:
            replace(R.id.frame_layout, addressFragment)

            // Agar bisa kembali (back) ke OrderFragment
            addToBackStack(null)
            commit()
        }
    }
}