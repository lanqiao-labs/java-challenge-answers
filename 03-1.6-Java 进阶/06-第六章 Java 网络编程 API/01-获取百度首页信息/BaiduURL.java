import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Teacher Tao
 *
 */
public class BaiduURL {
	
	public void infos() {
		BufferedReader br = null;
		
		try {
			URL url = new URL("https://www.baidu.com/index.html");
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			String s = br.readLine();
			while(s != null) {
				System.out.println(s);
				s = br.readLine();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new BaiduURL().infos();
	}

}
