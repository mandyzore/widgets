package qa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Exam {
	ArrayList<QA>QAlist ; //题库对象
	File file; //待导入的题库文件
	int num;//题目个数
	int index;//当前的测试题目id
	String name;
	
	
	public Exam(String path){
		index=0;
		this.load(path);
	}

	
	boolean load(String path){
		
		try {
			this.file=new File(path);
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(this.file),"UTF8"));
			String line=in.readLine();
			this.name=line;
			QA qa;
			this.num=0;
			line=in.readLine();
			this.QAlist=new ArrayList<QA>();
			while(line!=null){
				qa=new QA(line.split("##"));
				this.QAlist.add(qa);
				this.num++;
				line=in.readLine();
			}
			
			in.close();
//			System.out.println("load success!");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch blockß
			e.printStackTrace();
		}catch (  IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	public QA rand(){
		int id=0;
		id=(int)(Math.random()*this.num);
//		System.out.println("id: "+id);
		return this.QAlist.get(id);
	}
}
