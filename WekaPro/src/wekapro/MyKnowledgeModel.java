/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekapro;

import java.io.File;
import java.io.IOException;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NumericToNominal;
import weka.filters.unsupervised.attribute.Remove;

/**
 *
 * @author asus
 */
public class MyKnowledgeModel {
    DataSource source;
    Instances dataset;
    String[] model_option;
    String[] data_options;

    public MyKnowledgeModel() {
    }

    public MyKnowledgeModel(String filename,
            String m_opts,
            String d_opts) throws Exception {
        this.source = new DataSource(filename);
        this.dataset = source.getDataSet();
        this.model_option = weka.core.Utils.splitOptions(m_opts);
        this.data_options = weka.core.Utils.splitOptions(d_opts);
    }
    
    public Instances removeData(Instances originalData) throws Exception{
        Remove remove = new Remove();
        remove.setOptions(data_options);
        remove.setInputFormat(originalData);
        return Filter.useFilter(originalData, remove);
    }
    
    public Instances convertData(Instances originalData) throws Exception{
       NumericToNominal n2n = new NumericToNominal();
       n2n.setOptions(data_options);
       n2n.setInputFormat(originalData);
       return Filter.useFilter(originalData, n2n);
    }
    public void saveData(String filename) throws Exception{
        ArffSaver outData = new ArffSaver();
        outData.setInstances(this.dataset);
        outData.setFile(new File(filename));
        outData.writeBatch();
        System.out.println("Finished");
    }
    
    public void saveData2CSV(String filename) throws IOException{
        CSVSaver outData = new CSVSaver();
        outData.setInstances(this.dataset);
        outData.setFile(new File(filename));
        outData.writeBatch();
        System.out.println("Converted");
    }
    @Override
    public String toString() {
        return dataset.toSummaryString();
    }
    
    
}
