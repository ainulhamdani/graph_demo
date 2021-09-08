package id.keyta.graphdemo.ui.home;

import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;

public class MyHighlighter extends ChartHighlighter {

    public MyHighlighter(BarLineScatterCandleBubbleDataProvider chart) {
        super(chart);
    }

    @Override
    protected BarLineScatterCandleBubbleData getData() {
        return super.getData();
    }
}
