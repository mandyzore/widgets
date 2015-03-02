package qa;


public class QA {
	String qestion,awnser;
	public String getQestion() {
		return qestion;
	}
	public void setQestion(String qestion) {
		this.qestion = qestion;
	}
	public String getAwnser() {
		return awnser;
	}
	public void setAwnser(String awnser) {
		this.awnser = awnser;
	}
	public QA(String[] split) {
		// TODO Auto-generated constructor stub
		this.qestion=split[0];
		this.awnser=split[1];
	}

}
