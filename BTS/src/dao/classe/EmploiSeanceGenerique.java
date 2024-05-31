package dao.classe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Domaine.matiere.Matiere;
import Domaine.matiere.Module;

import Domaine.classe.Classe;


import Domaine.classe.Filiere;
import Domaine.classe.Niveau;
import Domaine.emploiDuTemps.SeanceGenerique;
import Domaine.locaux.Salle;
import Domaine.matiere.Periode;
import Domaine.personnel.Professeur;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dao.database.Db;
public class EmploiSeanceGenerique {
private Connection con;
	
	public  EmploiSeanceGenerique() {
		this.con = Db.getInstance().con;
	}
	public void insert(SeanceGenerique sg) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("insert into seancegenerique (ClasseID, MatiereID, ModuleID,ProfesseurUtilisateurID,SalleID,PeriodeID,Jour,HeureDebut,HeureFin,Duree,Observation) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		statement.setInt(1, sg.getClasse().getId());
		statement.setInt(2, sg.getMatiere().getId());
		statement.setInt(3, sg.getModule().getId());
		statement.setInt(4, sg.getProfesseur().getId());
		statement.setInt(5, sg.getSalle().getId());
		statement.setInt(6, sg.getPeriode() .getId());
		statement.setString(7, sg.getJour());
		statement.setString(8, sg.getHeureDebut());
		statement.setString(9, sg.getHeureFin());
		statement.setInt(10, sg.getDuree());
		statement.setString(11, sg.getObservation());
		statement.execute();
		statement.close();	
	}
	
	public ArrayList<SeanceGenerique> getAll(int id) throws SQLException{
		String query = "SELECT seancegenerique.ID,  `matiere`.`Nom_Fr` as matiere, `utilisateur`.`Nom_Fr`as professeur, `salle`.`Code` as salle,`jour`,`HeureDebut` as Debut,`HeureFin` as Fin  FROM `matiere`	, `professeur` , `salle` ,`seancegenerique`	, `utilisateur`,classe where `professeur`.`UtilisateurID` = `utilisateur`.`ID`and `seancegenerique`.`ProfesseurUtilisateurID`= `professeur`.`UtilisateurID`	and `salle`.`ID`=`seancegenerique`.`SalleID`and `seancegenerique`.`MatiereID`=`matiere`.`ID` and seancegenerique.ClasseID=classe.ID and seancegenerique.ClasseID=?;";
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		ArrayList<SeanceGenerique> sgn = new ArrayList();
		
		while (rs.next()) {
			  
			Salle salle=new Salle();
			salle.setCode(rs.getString("salle"));
			
			Matiere matiere =new Matiere();
			matiere.setNom_Fr(rs.getString("matiere"));
			
			Professeur prof=new Professeur();
			prof.setNom_Fr(rs.getString("professeur"));
			
			
			SeanceGenerique seg=new SeanceGenerique();
			
			seg.setHeureFin(rs.getString("Fin"));
			seg.setHeureDebut(rs.getString("Debut"));
			seg.setJour(rs.getString("jour"));
			seg.setProfesseur(prof);
			seg.setMatiere(matiere);
			seg.setSalle(salle);
			sgn.add(seg);
			}
		rs.close();
		statement.close();
		return sgn;
						
			
}
/*	
	public SeanceGenerique getById(int id) throws SQLException{	
		String query = "SELECT \r\n" + 
				"	`seance`.`ID` AS `num`,\r\n" + 
				"	`seance`.`HeureDebut` AS `Debut`,\r\n" +
				"	`seance`.`HeureFin` AS `Fin`,\r\n" + 
				"	`seance`.`jour`,\r\n" + 
				"	`classe`.`ID` AS `classID`,\r\n" +
				"	`classe`.`label` AS `label`,\r\n" +
				"	`seance`.`ProfesseurUtilisateurID` AS `prof`,\r\n" + 
				"	`module`.`Nom_Fr` AS `module`,\r\n" +
				"	`matiere`.`Nom_Fr` AS `matiere`,\r\n" + 
				"	`salle`.`code` AS `salle`,\r\n" + 
				"	`periode`.`code` AS `periode`,\r\n" + 
				"	FROM `seancegenerique seance`, `classe classe`, `module module`, `matiere matiere`, `periode periode`, `salle salle`\r\n" + 
				"	WHERE \r\n" + 
				"	(`classe`.`ID`= `seance`.`ClasseID`) AND\r\n" +
				"	(`module`.`ID`= `seance`.`ModuleID`) AND\r\n" +
				"	(`matiere`.`ID`= `seance`.`MatiereID`) AND\r\n" + 
				"	(`salle`.`ID`= `seance`.`salleID`) AND\r\n" + 
				"	(`periode`.`ID`= `seance`.`PeriodeID`) and \r\n" + 
				"	 (`seance`.`ID`= ? )                  ;\r\n";
				PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
				statement.setInt(1, id);
				ResultSet rs = statement.executeQuery();
				SeanceGenerique sgn = new SeanceGenerique ();
				
				while (rs.next()) {
					Classe classe=new Classe();
					classe.setId(rs.getInt("classeID"));
					classe.setLabel(rs.getString("label"));
					  
					Salle salle=new Salle();
					salle.setCode(rs.getString("salle"));
					
					
					Periode periode=new Periode();
					periode.setCode(rs.getString("periode"));
					
					
					Module module = new Module();
					module.setNom_Fr(rs.getString("module"));
					
					Matiere matiere =new Matiere();
					matiere.setNom_Fr(rs.getString("matiere"));
					
					SeanceGenerique seg=new SeanceGenerique();
					seg.setClasse(classe);
					seg.setHeureFin(rs.getString("Fin"));
					seg.setHeureDebut(rs.getString("Debut"));
					seg.setId(rs.getInt("num"));
					seg.setJour(rs.getString("jour"));
					seg.setPeriode(periode);
					seg.setProfesseur(rs.getInt("prof"));
					seg.setModule(module);
					seg.setMatiere(matiere);
					seg.setSalle(salle);
					}
				rs.close();
				statement.close();
				return sgn;
		
	}
	
	
	
	
	
	
*/}
