import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.HOGDescriptor;

public class Redimencionar extends Caracteristica {
	Path caminho = Paths.get("teste_2019_1.csv");	
	static ArrayList <Caracteristica> imagens = new ArrayList();
	
	public void calcularDistancia (Caracteristica cc, ArrayList a1) {
		float k;
		float y;
		float aux = 0;
		for (int i = 0; i < 1000; ++i) {
		k = cc.getInformacao(i);
		y = (float) a1.get(i);
		aux = aux + (float) Math.pow(k-y, 2);
		}
		cc.setSaldoDistance((float) Math.sqrt(aux));
	}


	
	public static void main(String[] args) {
		Redimencionar r1 = new Redimencionar() ;
		Caracteristica c1 = new Caracteristica();
		/*
		 * Processo no qual faz leitura de arquivos
		 * lerArq é o obj no qual contém o arquivo
		 */
		try {
		      FileReader arq = new FileReader("teste_2019_1.csv");
		      BufferedReader lerArq = new BufferedReader(arq);
		 
		      String linha = lerArq.readLine(); // lê a primeira linha
		// a variável "linha" recebe o valor "null" quando o processo
		// de repetição atingir o final do arquivo texto
		      int k = 0;
		      while (k  <= 20) {
		        /*
		         * Inicializa a váriável aux com uma linha do dataset  para poder usar o método split
		         */
		    	String aux = lerArq.readLine(); // lê da segunda até a última linha
		    	int i = 0;
		    	String cc = null;
		    	//Caracteristica c1 = new Caracteristica();
		    	while (i < 1001) {
		    		cc = aux.split(",")[i];
		    		if (i == 1000 ) {
		    			if (cc.equals("person")) {
		    			c1.setTipo("person");
		    			break;
		    			}
		    				c1.setTipo("noPerson");
		    			
		    			break;
		    			
		    		}
		    		
		    		//System.out.println(c1.getTipo());
		    		float f = Float.parseFloat(cc);
		    		c1.setInformacao(f);
		    		
		    		cc = "";
		    		i++;
		    	}
		    	imagens.add(c1);
		    	k++;
		      }
		      arq.close();
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n",
	          e.getMessage());
	    }
	//	Caracteristica c1 = new Caracteristica();
		
				
	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	
		HOGDescriptor hog = new HOGDescriptor();
		Mat img = new Mat();
		MatOfFloat features = new MatOfFloat();
		img = Imgcodecs.imread("C:\\Users\\Marlus\\Desktop\\imgs.png", Imgcodecs.IMREAD_GRAYSCALE);
		Imgproc.resize(img, img, new Size(64,128), 0.5, 0.5, Imgproc.INTER_LINEAR);
		hog.compute(img,features);
		
		List<Float> arrayOfFeatures = features.toList();
		//for (float kj : arrayOfFeatures) {
			//System.out.print(kj + " ");
		ArrayList<Float> a1	= new ArrayList ();
		for (int i = 0; i < 1000; ++i) {
			a1.add(arrayOfFeatures.get(i));			
		}
		
		//}
	//	System.out.println (arrayOfFeatures.size());
		//for (int i = 0; i < 10; i ++) {
		//	System.out.print(i + ") ");
			//for (int k = 0; k < 1000; k++) {
		r1.calcularDistancia(c1, a1);
				System.out.print (imagens.get(20).getInformacao(999) + ", ");
	//		}
	System.out.println (imagens.get(20).getTipo());
	System.out.println ("=8=88=8=8=8=88=8=8=888=8=8=88=8=8=");
	System.out.println (c1.getSaldoDistance());
	 
	
			
		//}
	}
}


