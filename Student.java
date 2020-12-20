class Student {
	private String srno;
	public String sname;
	private String ssub1;
	private String ssub2;
	private String ssub3;

	
	Student(){
	
	}

	
	public Student(String srno, String sname, String ssub1, String ssub2, String ssub3){
		this.srno = srno;
		this.sname = sname;
		this.ssub1 = ssub1;
		this.ssub2 = ssub2;
		this.ssub3 = ssub3;
		
	}


	
		
	public void setSrno(String srno){
		this.srno = srno;
	}
		
	public String getSrno(){
		return srno;
	}

	public void setSname(String sname){
		this.sname = sname;
	}
		
	public String getSname(){
		return sname;
	}

	public void setSsub1(String ssub1){
		this.ssub1 = ssub1;
	}
		
	public String getSsub1(){
		return ssub1;
	}

	public void setSsub2(String ssub2){
		this.ssub2 = ssub2;
	}
		
	public String getSsub2(){
		return ssub2;
	}

	public void setSsub3(String ssub3){
		this.ssub3 = ssub3;
	}
		
	public String getSsub3(){
		return ssub3;
	}
}