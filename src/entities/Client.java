package entities;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.text.ParseException;

	public class Client {

	    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");	
	    private int cod;
	    private String nameFull;
	    private char gender;
	    private Date dateNasc;
	    private String job;
	    private double salary;





	//CONSTRUTORES

	//# 1 PADRAO
	
	public Client() {

	}
	
	//# 2 CONSTRUTOR (SOBRECARGA) PASSAR TODOS ATRIBUTOS QUANDO OBJETO FOR INSTANCIANDO

	public Client (int cod, String nameFull,char gender,Date dateNasc,String job, double salary )  {
	this.cod = cod;
	this.nameFull = nameFull.toUpperCase();
	this.gender = Character.toUpperCase(gender);
	this.dateNasc = dateNasc;
	this.job = job.toUpperCase();
	this.salary = salary;

	}

	//METODOS GETTERS E SETTERS

	public int getCod(){
	
	  return cod;
	}
	

	public String getNameFull(){
	
	  return nameFull;
	}
	
	public void setNameFull(String nameFull){
	
	  this.nameFull = nameFull.toUpperCase();
	
	}

	public char getGender(){
	
	  return gender;
	}
	
	public void setGender(char gender){
	
	  this.gender = Character.toUpperCase(gender);
	
	}

	public Date getDateNasc(){
	
	  return dateNasc;
	}
	
	public void setDateNasc(Date dateNasc) {
	
	  this.dateNasc = dateNasc;
	
	}


	public String getJob(){
	
	  return job;
	}
	
	public void setJob(String job){
	
	  this.job = job.toUpperCase();
	
	}

	public double getSalary(){
	
	  return salary;
	}
	
	public void setSalary(double salary){
	
	  this.salary = salary;
	
	}
	//SOBRESCREVER O METODO TOSTRING
	
	 public String toString(){
	
	return  "\t\tCODIGO: "+ cod +
		"\n\t\tNOME COMPLETO: " + nameFull +
		"\n\t\tGENERO BIOLOGICO: "+gender +
		"\n\t\tDATA NASCIMENTO: "+ formatDate.format(getDateNasc())+
		"\n\t\tPROFISSAO: "+ job +
		String.format("\n\t\tSalario: R$ %.2f%n",salary);
	   	
	}

	 public int idade(){
		Date hoje = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(hoje);
		int idade = cal.get(Calendar.YEAR);
		cal.setTime(this.dateNasc);
		return idade - cal.get(Calendar.YEAR);
	
	  
	   	
	}

	}