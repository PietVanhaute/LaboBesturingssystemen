import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType( propOrder = { "pid", "arrivaltime", "servicetime" })
@XmlRootElement( name = "process")
public class Process {
	int pid,arrivaltime,servicetime;
	
//	public Process(){
//		
//	}
//	
//	public Process(int pid, int arrivaltime,int servicetime){
//		super();
//		this.pid = pid;
//		this.arrivaltime = arrivaltime;
//		this.servicetime = servicetime;
//	}
	
	public int getPid() {
		return pid;
	}
	
	@XmlElement(name = "pid")
	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getArrivaltime() {
		return arrivaltime;
	}
	
	@XmlElement(name = "arrivaltime")
	public void setArrivaltime(int arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public int getServicetime() {
		return servicetime;
	}
	
	@XmlElement(name = "servicetime")
	public void setServicetime(int servicetime) {
		this.servicetime = servicetime;
	}
	
}
