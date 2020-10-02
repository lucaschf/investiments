package tsi.too.investmentcalculation;

import tsi.too.investmentcalculation.controller.InvestimentController;

public class Application {

	public static void main(String[] args) {
		String dataSource[] ={
				"RF;CDB Original;AAA;sim;18; 2.000,00 ;10%;14/01/2018;-" ,
				"RF;Tesouro Direto;B+;não;24; 1.500,00 ;9.5%;14/02/2018;-" ,
				"RF;LC Pernambucanas;AA;sim;36; 5.000,00 ;10.6%;14/03/2018;-" ,
				"RF;CDB PAN;BB+;sim;36; 4.500,00 ;11%;14/04/2018;-;" ,
				"RF;CDB BTG Pactual;BB;sim;24; 3.100,00 ;7.8%;14/05/2018;-" ,
				"RF;Tesouro Direto;BB-;não;6; 800,00 ;11%;14/06/2018;-" ,
				"RF;LC BMT;AA;sim;18; 3.500,00 ;8.7%;14/07/2018;-" ,
				"RF;CDB BMG;AA+;sim;12; 2.900,00 ;9.6%;14/08/2018;-" ,
				"RF;CDB Fibra;AAA;sim;24; 5.800,00 ;10.7%;14/09/2018;-" ,
				"RF;CDB Agibank;A-;sim;36; 4.100,00 ;9.8%;14/10/2018;-" ,
				"RF;CDB BVB;BBB+;sim;30; 6.200,00 ;11.6%;14/11/2018;-" ,
				"RF;LC KMT;BBB;sim;6; 3.400,00 ;12.5%;14/12/2018;-" ,
				"RV;Ações da Vale;BBB+;não;-; 4.500,00 ;35%;20/12/2016;20/10/2019" ,
				"RV;Ações do Magazine Luíza;A;não;-; 4.000,00 ;58%;15/01/2017;21/10/2019" ,				
				"RV;Ações do Itaú;A+;não;-; 2.000,00 ;48%;10/02/2017;22/10/2018" ,
				"RV;Fundo de Ações I;BBB;não;-; 2.500,00 ;42.6%;09/03/2017;23/10/2018" ,
				"RV;Fundo de Ações II;BBB+;não;-; 2.500,00 ;38.7%;14/04/2017;24/10/2018"
		};

		InvestimentController.getInstance().execute(dataSource);
	}
}
