package id.keyta.graphdemo.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

import id.keyta.graphdemo.R;
import id.keyta.graphdemo.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setData(6, 20);
    }

    private void setData(int count, float range) {

        ArrayList<Entry> values = new ArrayList<>();
        ArrayList<Entry> values2 = new ArrayList<>();
        ArrayList<BarEntry> barEntries = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            values.add(new Entry(i, (int) (Math.random() * range*2+5), null));
            values2.add(new Entry(i, (int) (Math.random() * range), null));
            barEntries.add(new BarEntry(i, (int) (Math.random() * range), null));
        }

        BarDataSet set2;

        LineDataSet lineDataSet = new LineDataSet(values, "Jumlah Transaksi");
        LineDataSet lineDataSet2 = new LineDataSet(values2, "Jumlah Order");
        LineDataSet lineDataSet3 = new LineDataSet(values, "Jumlah Transaksi");
        LineDataSet lineDataSet4 = new LineDataSet(values2, "Jumlah Order");
        LineDataSet lineDataSet5 = new LineDataSet(values, "Jumlah Transaksi");
        LineDataSet lineDataSet6 = new LineDataSet(values2, "Jumlah Order");
        set2 = new BarDataSet(barEntries, "Jumlah Transaksi");

        lineDataSet.setDrawIcons(false);
        lineDataSet.setDrawValues(false);
        lineDataSet.setDrawCircles(false);
        lineDataSet.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
        lineDataSet.disableDashedLine();
        lineDataSet.setColor(Color.RED);
        lineDataSet.setFillColor(Color.RED);
        lineDataSet.setDrawFilled(true);
        lineDataSet.setLineWidth(0);

        lineDataSet2.setDrawIcons(false);
        lineDataSet2.setDrawValues(false);
        lineDataSet2.setDrawCircles(false);
        lineDataSet2.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
        lineDataSet2.disableDashedLine();
        lineDataSet2.setColor(Color.BLUE);
        lineDataSet2.setFillColor(Color.BLUE);
        lineDataSet2.setDrawFilled(true);
        lineDataSet2.setLineWidth(0);

        lineDataSet3.setDrawIcons(false);
        lineDataSet3.setDrawValues(false);
        lineDataSet3.setDrawCircles(false);
        lineDataSet3.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
        lineDataSet3.disableDashedLine();
        lineDataSet3.setColor(Color.RED);
        lineDataSet3.setLineWidth(2f);

        lineDataSet4.setDrawIcons(false);
        lineDataSet4.setDrawValues(false);
        lineDataSet4.setDrawCircles(false);
        lineDataSet4.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
        lineDataSet4.disableDashedLine();
        lineDataSet4.setColor(Color.BLUE);
        lineDataSet4.setLineWidth(2f);

        lineDataSet5.setDrawIcons(false);
        lineDataSet5.setDrawValues(false);
        lineDataSet5.setDrawCircles(false);
        lineDataSet5.disableDashedLine();
        lineDataSet5.setColor(Color.RED);
        lineDataSet5.setLineWidth(2f);

        lineDataSet6.setDrawIcons(false);
        lineDataSet6.setDrawValues(false);
        lineDataSet6.setDrawCircles(false);
        lineDataSet6.disableDashedLine();
        lineDataSet6.setColor(Color.BLUE);
        lineDataSet6.setLineWidth(2f);

        set2.setDrawIcons(false);
        set2.setDrawValues(false);
        set2.setColor(Color.BLUE);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet); // add the data sets
        dataSets.add(lineDataSet2); // add the data sets

        ArrayList<ILineDataSet> dataSets2 = new ArrayList<>();
        dataSets2.add(lineDataSet3); // add the data sets
        dataSets2.add(lineDataSet4); // add the data sets

        ArrayList<ILineDataSet> dataSets3 = new ArrayList<>();
        dataSets3.add(lineDataSet5); // add the data sets
        dataSets3.add(lineDataSet6); // add the data sets

        ArrayList<IBarDataSet> barDataSets = new ArrayList<>();
        barDataSets.add(set2);

        // create a data object with the data sets
        LineData data = new LineData(dataSets);
        data.setHighlightEnabled(true);
        LineData data2 = new LineData(dataSets2);
        data2.setHighlightEnabled(true);
        LineData data3 = new LineData(dataSets3);
        data3.setHighlightEnabled(true);
        BarData barData = new BarData(barDataSets);

        final ArrayList<String> xLabel = new ArrayList<>();
        xLabel.add("Jan");
        xLabel.add("Feb");
        xLabel.add("Mar");
        xLabel.add("Apr");
        xLabel.add("Mei");
        xLabel.add("Jun");
        xLabel.add("Jul");
        xLabel.add("Agu");
        xLabel.add("Sep");
        xLabel.add("Okt");
        xLabel.add("Nov");
        xLabel.add("Des");
        String[] strings = xLabel.toArray(new String[0]);
        IndexAxisValueFormatter indexAxisValueFormatter = new IndexAxisValueFormatter();
        indexAxisValueFormatter.setValues(strings);

        // set data
        binding.linechart1.setBackgroundColor(Color.WHITE);
        binding.linechart1.setDrawGridBackground(false);
        binding.linechart1.getDescription().setEnabled(false);
        binding.linechart1.setData(data);
        binding.linechart1.getAxisLeft().setDrawGridLines(false);
        binding.linechart1.setDrawMarkers(true);
        CustomMarkerView customMarkerView = new CustomMarkerView(getActivity(), R.layout.custom_marker_view_layout);
        customMarkerView.setChartView(binding.linechart1);
        binding.linechart1.setMarker(customMarkerView);
        //binding.linechart1.getLegend().setEnabled(false);

        binding.linechart2.setBackgroundColor(Color.WHITE);
        binding.linechart2.setDrawGridBackground(false);
        binding.linechart2.getDescription().setEnabled(false);
        binding.linechart2.setData(data2);
        binding.linechart2.getAxisLeft().setDrawGridLines(false);
        binding.linechart2.setDrawMarkers(true);
        CustomMarkerView customMarkerView2 = new CustomMarkerView(getActivity(), R.layout.custom_marker_view_layout);
        customMarkerView.setChartView(binding.linechart2);
        binding.linechart2.setMarker(customMarkerView2);
        //binding.linechart2.getLegend().setEnabled(false);

        binding.linechart3.setBackgroundColor(Color.WHITE);
        binding.linechart3.setDrawGridBackground(false);
        binding.linechart3.getDescription().setEnabled(false);
        binding.linechart3.setData(data3);
        binding.linechart3.getAxisLeft().setDrawGridLines(false);
        binding.linechart3.setDrawMarkers(true);
        CustomMarkerView customMarkerView3 = new CustomMarkerView(getActivity(), R.layout.custom_marker_view_layout);
        customMarkerView.setChartView(binding.linechart3);
        binding.linechart3.setMarker(customMarkerView3);
        //binding.linechart3.getLegend().setEnabled(false);

        XAxis xAxis = binding.linechart1.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(indexAxisValueFormatter);
        binding.linechart1.getAxisLeft().setAxisMinimum(0);
        binding.linechart1.getAxisRight().setAxisMinimum(0);

        binding.linechart2.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        binding.linechart2.getXAxis().setDrawGridLines(false);
        binding.linechart2.getXAxis().setGranularity(1f);
        binding.linechart2.getXAxis().setValueFormatter(indexAxisValueFormatter);
        binding.linechart1.getAxisLeft().setAxisMinimum(0);
        binding.linechart1.getAxisRight().setAxisMinimum(0);

        binding.linechart3.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        binding.linechart3.getXAxis().setDrawGridLines(false);
        binding.linechart3.getXAxis().setGranularity(1f);
        binding.linechart3.getXAxis().setValueFormatter(indexAxisValueFormatter);
        binding.linechart1.getAxisLeft().setAxisMinimum(0);
        binding.linechart1.getAxisRight().setAxisMinimum(0);



        XAxis xAxisBar = binding.chart2.getXAxis();
        xAxisBar.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxisBar.setDrawGridLines(false);
        xAxisBar.setGranularity(1f);
        xAxisBar.setValueFormatter(indexAxisValueFormatter);
        binding.chart2.getAxisLeft().setAxisMinimum(0);
        binding.chart2.getAxisRight().setAxisMinimum(0);
        binding.chart2.setBackgroundColor(Color.WHITE);
        binding.chart2.setDrawGridBackground(false);
        binding.chart2.getDescription().setEnabled(false);
        binding.chart2.setDrawMarkers(true);
        CustomMarkerView customMarkerView4 = new CustomMarkerView(getActivity(), R.layout.custom_marker_view_layout);
        customMarkerView.setChartView(binding.chart2);
        binding.chart2.setMarker(customMarkerView4);
        //binding.chart2.getLegend().setEnabled(false);


        binding.chart2.setData(barData);

        binding.linechart1.animateX(2000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}