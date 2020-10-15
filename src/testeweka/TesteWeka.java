/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeweka;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author rodri
 */
public class TesteWeka {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        DataSource ds = new DataSource("src/testeweka/diagnostico.arff");
        Instances ins = ds.getDataSet();
       // System.out.println(ins.toString());
        
        ins.setClassIndex(5);
       
        NaiveBayes nb = new NaiveBayes();
        nb.buildClassifier(ins);
        
        Instance novo = new DenseInstance(6);
        novo.setDataset(ins);
        novo.setValue(0, "falta_de_ar");
        novo.setValue(1, "sim" );
        novo.setValue(2, "7-14");
        novo.setValue(3, "sim");
        novo.setValue(4, ">=37");
        
        double probabilidade[] = nb.distributionForInstance(novo);
        System.out.println("sim: " + probabilidade[0]);
        System.out.println("nao: " + probabilidade[1]);
        
        
        
                
    
    }
    
}
