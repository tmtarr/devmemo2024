import java.awt.Font;
import java.io.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.title.*;
import org.jfree.data.category.DefaultCategoryDataset;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.data.general.DefaultPieDataset;

import org.jfree.chart.ChartUtilities;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.StandardChartTheme;

public class FontChk{
  public static void main(String[] args) {
    System.out.println("こんにちは");

    StandardChartTheme sc = (StandardChartTheme)StandardChartTheme.createJFreeTheme();
    System.out.println(sc.getExtraLargeFont());
    System.out.println(sc.getLargeFont());
    System.out.println(sc.getRegularFont());

//    Font font = new Font("MS Mincho", Font.BOLD, 30);
    Font font = new Font("Noto Sans JP", Font.BOLD, 30);
    sc.setExtraLargeFont(font);
    sc.setLargeFont(font);
    sc.setRegularFont(font);
    
    System.out.println(sc.getExtraLargeFont());
    System.out.println(sc.getLargeFont());
    System.out.println(sc.getRegularFont());

    DefaultPieDataset data = new DefaultPieDataset();

    data.setValue("Asahi", 37);
    data.setValue("Kirin", 36);
    data.setValue("サントリー", 13);
    data.setValue("サッポロ", 12);
    data.setValue("その他", 2);

    JFreeChart chart = 
      ChartFactory.createPieChart("Sample", data, true, false, false);

    sc.apply(chart);
    File file = new File("./chart.png");
    try {
      ChartUtilities.saveChartAsPNG(file, chart, 500, 500);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
