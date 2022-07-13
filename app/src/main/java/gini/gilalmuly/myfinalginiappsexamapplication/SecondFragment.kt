package gini.gilalmuly.myfinalginiappsexamapplication

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.Fragment
import androidx.work.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

import dagger.hilt.android.AndroidEntryPoint
import gini.gilalmuly.myfinalginiappsexamapplication.databinding.FragmentSecondBinding
import java.util.concurrent.TimeUnit
import kotlin.system.exitProcess


@AndroidEntryPoint
class SecondFragment : Fragment(), OnMapReadyCallback {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private var map: GoogleMap? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("InflateParams")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mapView.onCreate(savedInstanceState)
        binding.mapView.getMapAsync {
            val point = LatLng(32.160485, 34.809805)
            it.addMarker(MarkerOptions().position(point).title("Gini Apps Offices"))
            it.moveCamera(CameraUpdateFactory.newLatLng(point))
            it.animateCamera(CameraUpdateFactory.newLatLngZoom(point,15f))
            it.setOnMapClickListener {

                Log.d("Map_Tag", it.latitude.toString())
                Log.d("Map_Tag", it.longitude.toString())

                /*val bottomSheetDialog = BottomSheetDialog(requireContext(),R.style.Theme_MyFinalGiniAppsExamApplication_NoActionBar)
                val bottomSheetView = LayoutInflater.from(context).inflate(R.layout.layout_buttom_sheet, null)
                bottomSheetDialog.setContentView(bottomSheetView)
                bottomSheetDialog.show()*/
            }

        }
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // Add a marker in Sydney and move the camera

    }

}