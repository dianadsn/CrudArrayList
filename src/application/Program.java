    package application;
   
    import java.util.Scanner;
    import java.util.Locale;
    import entities.Client;
    import java.util.List;
    import java.util.ArrayList;
    import entities.Client;
    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.io.IOException; 
	public class Program {

	    public static void main(String[] args) throws ParseException, IOException {

	        Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);
	    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		List<Client> client = new ArrayList<>();
		int op;

		Logo();
		
		do {
		 
	          Menu();
                  System.out.print("\t\t\tEscolha uma opcao: ");
		  op = teclado.nextInt();

		 switch(op){

			case 0:
                 	    System.out.println("\n\t\tSaindo do sistema.....");
			    espera(1000);		
			break;

			//CADASTRAR CLIENTE
			case 1:
			
			char sair ;
			
			do {
			    MenuCadClient();
                  	    System.out.print("\n\t\tCodigo: ");
			    int cod = teclado.nextInt();
				
				while(validaCod(client,cod)!=null){
				    System.out.print("\n\t\t\t\t     CODIGO JA CADASTRADO!!!!!!\n");
				    System.out.println("\n\t\t\t\t POR FAVOR DIGITE UM CODIGO VALIDO. ");
             	                    System.out.print("\n\t\tCodigo: ");
					cod = teclado.nextInt();
				}
				teclado.nextLine();

                  	    System.out.print("\n\t\tNome completo: ");
			    String nameFull = teclado.nextLine();
			
			    System.out.print("\n\t\tGenero biologico: ");
			    char gender = teclado.next().charAt(0);

			    System.out.print("\n\t\tData nascimento: ");
			    String dateNasc = teclado.next();

				teclado.nextLine();

                  	    System.out.print("\n\t\tProfissao: ");
			    String job = teclado.nextLine();
				

                  	    System.out.print("\n\t\tSalario: R$ ");
			    double salary = teclado.nextDouble();
				client.add(new Client (cod,nameFull,gender,formatDate.parse(dateNasc),job,salary));

			    System.out.print("\n\t\tDeseja adicionar outro cliente s(sim)/n(nao): ");
			    sair = teclado.next().charAt(0);
			
			    while(sair!='s' && sair!='n'){

			       System.out.print("\n\t\t\tOpcao invalida!!!\n\t\tDeseja adicionar outro cliente s(sim) | n(nao): ");
			       sair = teclado.next().charAt(0);


			       System.out.println();
				}
			     if(sair =='n'){
			        System.out.println("\n\t\t\tVoltando ao menu inicial......");
				espera(1000);
				
			      }

			}while(sair == 's');

			Logo();
			break;
			
			//LISTAR CLIENTE
			case 2:
			System.out.println();
			System.out.println("\n\t\t----------------------LISTA DE CLIENTES----------------------\n");

			for(Client cli:client){
			System.out.println("\n\t\tCODIGO: "+cli.getCod());
			System.out.println("\n\t\tNOME COMPLETO: "+cli.getNameFull());
			System.out.println("\n\t\tGENERO BIOLOGICO: "+cli.getGender());
			System.out.println("\n\t\tDATA NASCIMENTO: "+ formatDate.format(cli.getDateNasc()));
			System.out.println("\n\t\tPROFISSAO: "+ cli.getJob());
			System.out.printf("\n\t\tSalario: R$ %.2f%n",cli.getSalary());
			System.out.println("\n\t\tIdade: "+cli.idade());
			System.out.println("\n\t\t--------------------------------------------------------------\n");
                        System.out.println();
                        System.in.read();//pausa enquanto a tecla enter nao for clicada
			}

			break;

			//CONSULTAR CLIENTE
			case 3:
			System.out.println();
			System.out.println("\n\t\t----------------------CONSULTA DE CLIENTES----------------------\n");
			System.out.print("\n\t\tDigite o codigo do cliente:\n");
			    int con = teclado.nextInt();
                        Client cli = validaCod(client,con);
			if(cli!=null){
			System.out.println("\n\t\tCODIGO: "+cli.getCod());
			System.out.println("\n\t\tNOME COMPLETO: "+cli.getNameFull());
			System.out.println("\n\t\tGENERO BIOLOGICO: "+cli.getGender());
			System.out.println("\n\t\tDATA NASCIMENTO: "+ formatDate.format(cli.getDateNasc()));
			System.out.println("\n\t\tPROFISSAO: "+ cli.getJob());
			System.out.printf("\n\t\tSalario: R$ %.2f%n",cli.getSalary());
			System.out.println("\n\t\tIdade: "+cli.idade());
			System.out.println("\n\t\t--------------------------------------------------------------\n");
                        System.out.println();
			}else{
			System.out.println("\n\t\tCliente nao encontrado!!!!");
                        System.out.println();
			}
		

			break;

			//EDITAR CLIENTE
			case 4:
			System.out.println();
			System.out.println("\n\t\t----------------------EDITAR DE CLIENTES----------------------\n");
			System.out.print("\n\t\tDigite o codigo do cliente: ");
			    int ed = teclado.nextInt();
                        Client clie = validaCod(client,ed);

			if(clie!=null){
			System.out.println("\n\t\tDADOS ATUAIS DO CLIENTE");
			System.out.println(clie);
			teclado.nextLine();

                  	    System.out.print("\n\t\tNome completo: ");
			  String   nameFull = teclado.nextLine();
			clie.setNameFull(nameFull);

			    System.out.print("\n\t\tGenero biologico: ");
			  char  gender = teclado.next().charAt(0);
				clie.setGender(gender);
			    System.out.print("\n\t\tData nascimento: ");
			   String  dateNasc = teclado.next();
				clie.setDateNasc(formatDate.parse(dateNasc));
				teclado.nextLine();

                  	    System.out.print("\n\t\tProfissao: ");
			  String   job = teclado.nextLine();
				clie.setJob(job);

                  	    System.out.print("\n\t\tSalario: R$ ");
			    double salary = teclado.nextDouble();
				clie.setSalary(salary);

			System.out.println("\n\t\tDADOS ATUALIZADOS COM SUCESSO");
			System.out.println(clie);
			System.out.println("\n\t\t--------------------------------------------------------------\n");
                        System.out.println();
			}else{
			System.out.println("\n\t\tCliente nao encontrado!!!!");
                        System.out.println();
			}
		

			break;
			//EXCLUIR CLIENTE
			case 5:
			System.out.println();
			System.out.println("\n\t\t----------------------EXCLUIR CLIENTE----------------------\n");
			System.out.print("\n\t\tDigite o codigo do cliente: ");
			    ed = teclado.nextInt();
                        clie = validaCod(client,ed);

			if(clie!=null){
			System.out.println("\n\t\tINFORMACOES DO CLIENTE");
			System.out.println(clie);
			teclado.nextLine();

                  	    System.out.print("\n\t\tTem certeza que deseja exluir o cliente \n\t\t"+ clie.getNameFull()+" | Codigo: "+clie.getCod()+" \n\t\ts(sim) ou n(nao):");
			  char excl = teclado.next().charAt(0);
			if(excl == 's'){
                            excluirClient(client,clie.getCod());      
			System.out.println("\n\t\tCLIENTE EXCLUIDO COM SUCESSO!!!!");
			}

			}else{
			System.out.println("\n\t\tCliente nao encontrado!!!!");
                        System.out.println();
			}
		

			break;

			default:
                  	    System.out.println("\n\t\tOpcao invalida!!\n\t\tEscolha novamente.");			
			break;

		}


		}while(op!=0);//enquanto opcao for diferente de 0 continue repetindo o bloco


	      teclado.close();
	    }
	
	    private static void Logo(){

	        System.out.println();
                System.out.println("\t\t\t|#########################|");
	        System.out.println("\t\t\t|#|    BEM VINDOS  A    |#|");
	        System.out.println("\t\t\t|#|                     |#|");
	        System.out.println("\t\t\t|#|      DROBOTEC       |#|");
                System.out.println("\t\t\t|#########################|");
	        System.out.println();
		espera(1000);

	    }

	    public static void Menu(){

                System.out.println("\t\t\t ------------MENU----------- ");
	        System.out.println("\t\t\t|                           |");
	        System.out.println("\t\t\t|   1 - Cadastrar Clientes  |");
	        System.out.println("\t\t\t|   2 - Listar Clientes     |");
	        System.out.println("\t\t\t|   3 - Consultar Cliente   |");
	        System.out.println("\t\t\t|   4 - Editar Cliente      |");
	        System.out.println("\t\t\t|   5 - Excluir Cliente     |");
	        System.out.println("\t\t\t|   0 - Sair                |");
	        System.out.println("\t\t\t|                           |");
                System.out.println("\t\t\t ---------------------------");
               // System.out.println("\t\t\t|                         |");
	        System.out.println();

	    }	
	     private static void MenuCadClient(){
               System.out.println();
                System.out.println("\t\t\t ----------- Formulario Cliente ---------- ");
	        System.out.println();

	    }
	     private static void espera(long timeWait){
		
		try { //Abrir o try
		 Thread.sleep(timeWait);//funcao de espera recebendo o tempo 1000 equivale a 1s
 		
		} catch(InterruptedException ex){
		
		Thread.currentThread().interrupt();//em caso de erro interromper a Thread corrente
		}

	        System.out.println();

	    }	
		private static Client validaCod(List<Client> lista,int cod){
                  Client cli = lista.stream().filter(x -> x.getCod() == cod).findFirst().orElse(null);
                  return cli;

	        }
		private static void excluirClient(List<Client> lista,int cod){
                  lista.removeIf(x -> x.getCod() == cod);
               
	        }
	
		

	}