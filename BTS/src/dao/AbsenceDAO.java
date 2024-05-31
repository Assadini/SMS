package dao.etudiant;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Domaine.classe.AnneeScolaire;
import Domaine.classe.Classe;
import Domaine.classe.ClasseGenerique;
import Domaine.classe.Cycle;
import Domaine.classe.Filiere;
import Domaine.classe.Niveau;
import Domaine.emploiDuTemps.Seance;
import Domaine.emploiDuTemps.SeanceGenerique;
import Domaine.etablissement.Etablissement;
import Domaine.etudiant.AbsenceEtudiant;
import Domaine.etudiant.DocJustifAbsEtudiant;
import Domaine.etudiant.Etudiant;
import Domaine.etudiant.Mention;
import Domaine.etudiant.OptionBac;
import Domaine.etudiant.Parent;
import Domaine.etudiant.Scolarite;
import Domaine.etudiant.Statistiques;
import Domaine.matiere.Matiere;
import Domaine.personnel.Professeur;
import dao.database.Db;

public class AbsenceDAO {
private static Connection con;
public AbsenceDAO() {
	this.con = Db.getInstance().con;
}
public static void insert( AbsenceEtudiant absence )throws SQLException{
	String sql="insert into absenceetudiant"
			+ "(ID,"
			+ "EtudiantUtilisateurID,"
			+ "SeanceID,"
			+ "Justification,"
			+ "Motif,"
			+ "DocJustifAbsEtudiantID)values"
			+ "(NULL,?,?,?,?,?);";
 PreparedStatement pst=(PreparedStatement)con.prepareStatement(sql);
 pst.setInt(1, absence.getId());
 pst.setInt(2, absence.getEtudiant().getId());
 pst.setInt(3, absence.getSeance().getId());
 pst.setBoolean(4, absence.getJustification());
 pst.setString(5, absence.getMotif());
 pst.setObject(6, absence.getDocumentJustificatif());
 pst.execute();
 pst.close();
}
public static ArrayList<AbsenceEtudiant> getAll() throws SQLException{
	String req="select ID as absenceId,"
			+ "Justification,Motif,"+
			"   `utilisateur`.`Titre`,\r\n" +
			"	`utilisateur`.`Sexe`,\r\n" +
			"	`utilisateur`.`Cin`,\r\n" +
			"	`utilisateur`.`Nom_Fr`,\r\n" + 
			"	`utilisateur`.`Prenom_Fr`,\r\n" + 
			"	`utilisateur`.`Nom_Ar`,\r\n" + 
			"	`utilisateur`.`Prenom_Ar`,\r\n" + 
			"	`utilisateur`.`Nationalite`,\r\n" + 
			"	`utilisateur`.`DateNais`,\r\n" +
			"	`utilisateur`.`LieuNais_Fr`,\r\n" +
			"	`utilisateur`.`LieuNais_Ar`,\r\n" +
			"	`utilisateur`.`Adresse_Fr`,\r\n" +
			"	`utilisateur`.`Adresse_Ar`,\r\n" +
			"	`utilisateur`.`Email`,\r\n" +
			"	`utilisateur`.`SituationF`,\r\n" +
			"	`utilisateur`.`TeleMobile`,\r\n" +
			"	`utilisateur`.`TeleDomicile`,\r\n" +
			"	`utilisateur`.`Photo`,\r\n" +
			"	`etudiant`.`UtilisateurID` as EtudiantID ,\r\n" +
			"	`etudiant`.`Cne`,\r\n" +
			"	`etudiant`.`NumInscription`,\r\n" +
			"	`etudiant`.`AnneeBac`,\r\n" +
			"	`etudiant`.`Candidat`,\r\n" +
			"	`etudiant`.`Etat`,\r\n" +
			"	`etablissement`.`ID` as EtablissementID,\r\n" +
			"	`etablissement`.`Code` as EtablissementCode,\r\n" +
			"	`etablissement`.`Nom_Fr` as EtablissementNom_Fr,\r\n" +
			"	`etablissement`.`Nom_Ar` as EtablissementNom_Ar,\r\n" +
			"	`etablissement`.`Adresse_Fr` as EtablissementAdresse_Fr,\r\n" +
			"	`etablissement`.`Adresse_Ar` as EtablissementAdresse_Ar,\r\n" +
			"	`etablissement`.`Telephone` as EtablissementTel,\r\n" +
			"	`etablissement`.`Email` as EtablissementEmail,\r\n" +
			"	`filiere`.`ID` as FiliereID,\r\n" +
			"	`filiere`.`Code` as FiliereCode,\r\n" +
			"	`filiere`.`Nom_Fr` as FiliereNom_Fr,\r\n" +
			"	`filiere`.`Nom_Ar` as FiliereNom_Ar,\r\n" +
			"	`optionbac`.`ID` as OptionBacID,\r\n" +
			"	`optionbac`.`Code` as OptionBacCode,\r\n" +
			"	`optionbac`.`Nom_Fr` as OptionBacNom_Fr,\r\n" +
			"	`optionbac`.`Nom_Ar` as OptionBacNom_Ar,\r\n" +
			"	`etudiant`.`MoyenneBac`,\r\n" +
			"	`mention`.`ID` as MentionBacID,\r\n" +
			"	`mention`.`Code` as MentionBacCode,\r\n" +
			"	`mention`.`Nom_Fr` as MentionBacNom_Fr,\r\n" +
			"	`mention`.`Nom_Ar` as MentionBacNom_Ar,\r\n"+
			"	`utilisateurParent`.`ID` AS `ParentID` ,\r\n" +
			"	`utilisateurParent`.`Titre` AS `TitreParent`,\r\n" +
			"	`utilisateurParent`.`Sexe` AS `SexeParent`,\r\n" +
			"	`utilisateurParent`.`Cin` AS `CinParent`,\r\n" +
			"	`utilisateurParent`.`Nom_Fr` AS `Nom_FrParent`,\r\n" + 
			"	`utilisateurParent`.`Prenom_Fr` AS `Prenom_FrParent`,\r\n" + 
			"	`utilisateurParent`.`Nom_Ar` AS `Nom_ArParent`,\r\n" + 
			"	`utilisateurParent`.`Prenom_Ar` AS `Prenom_ArParent`,\r\n" + 
			"	`utilisateurParent`.`Nationalite` AS `NationaliteParent`,\r\n" + 
			"	`utilisateurParent`.`DateNais` AS `DateNaisParent`,\r\n" +
			"	`utilisateurParent`.`LieuNais_Fr` AS `LieuNais_FrParent`,\r\n" +
			"	`utilisateurParent`.`LieuNais_Ar` AS `LieuNais_ArParent`,\r\n" +
			"	`utilisateurParent`.`Adresse_Fr` AS `Adresse_FrParent`,\r\n" +
			"	`utilisateurParent`.`Adresse_Ar` AS `Adresse_ArParent`,\r\n" +
			"	`utilisateurParent`.`Email` AS `EmailParent`,\r\n" +
			"	`utilisateurParent`.`SituationF` AS `SituationFParent`,\r\n" +
			"	`utilisateurParent`.`TeleMobile` AS `TeleMobileParent`,\r\n" +
			"	`utilisateurParent`.`TeleDomicile` AS `TeleDomicileParent`,\r\n" +
			"	`utilisateurParent`.`Photo` AS `PhotoParent`,\r\n" +
			"	`parent`.`LienParente`\r\n" +
			"   `seance` .`ID` as SeanceID,\r\n"+
			"   `seance` .`Date` ,\r\n"+
		    "   `seance` .`Etat` ,\r\n" +
		    "   `seance` .`Observation` ,"+
		    "   `seancegenerique`.`ID` as seancegeneriqueID,\r\n"+
		    "   `seancegenerique`.`Jour`,\r\n"+
		    "   `seancegenerique`.`HeureDebut`,\r\n"+
		    "   `seancegenerique`.`HeureFin`,\r\n"+
		    "   `seancegenerique`.`Duree`,\r\n"+
		    "   `seancegenerique`.`Observation`,\r\n"+
		    "   `docjustifabsetudiant`.`ID` as justifabsID,\r\n"+
		    "   `docjustifabsetudiant`.`Code`,\r\n"+
		    "   `docjustifabsetudiant`.`Nom`,\r\n"+
		    "   `docjustifabsetudiant`.`DateDepot`,\r\n"+
		    "   `docjustifabsetudiant`.`DateDebut`,\r\n"+
		    "   `docjustifabsetudiant`.`DateFin`,\r\n"+
		    "   `docjustifabsetudiant`.`Emplacement`,\r\n"+
		    "   `docjustifabsetudiant`.`Type`,\r\n"+
		    "   `docjustifabsetudiant`.`Taille`,\r\n"+
		    "   `docjustifabsetudiant`.`DateUpload`,\r\n"+
		    "   `docjustifabsetudiant`.`Observation`,\r\n"+
		    " from \r\n"+
		    "	`absenceetudiant`, `utilisateur`, `etudiant`, `optionbac`, `mention`, `filiere`, `etablissement`,`utilisateur` AS `utilisateurParent`,`parent`,"+
		    "   `seance`, `seancegenerique` , `docjustifabsetudiant` \r\n"+
		    "where \r\n"+
		    "   (`absenceetudiant`.`EtudiantUtilisateurID`= `etudiant`.`UtilisateurID`) AND \r\n"+
		    "   (`absenceetudiant`.`SeanceID`= `seance`.`ID`) AND \r\n"+
		    "   (`seance`.`SeanceGeneriqueID`= `seancegenerique`.`ID`) AND \r\n"+
		    "   (`absenceetudiant`. `DocJustifAbsEtudiantID`= `docjustifabsetudiant`.`ID`) AND \r\n"+
		    "	(`etudiant`.`UtilisateurID` = `utilisateur`.`ID` ) AND\r\n" + 
			"	(`etudiant`.`OptionBacID` = `optionbac`.`ID`) AND\r\n" + 
			"	(`etudiant`.`MentionID` = `mention`.`ID`) AND\r\n" +
			"	(`etudiant`.`FiliereID` = `filiere`.`ID`) AND\r\n" + 
			"	(`etudiant`.`EtablissementID` = `etablissement`.`ID`) AND \r\n"+
			"	(`utilisateurParent`.`ID` = `etudiant`.`ParentUtilisateurID`) AND \r\n"+
			"	(`etudiant`.`ParentUtilisateurID` = `parent`.`UtilisateurID`);" ;
			
	PreparedStatement statement = (PreparedStatement) con.prepareStatement(req);
	ResultSet rs = statement.executeQuery();
	ArrayList<AbsenceEtudiant> absetd=new ArrayList<AbsenceEtudiant>();
	AbsenceEtudiant absenceetudiant =null;
	while(rs.next()) {
		absenceetudiant=new AbsenceEtudiant();
		absenceetudiant.setId(rs.getInt("absenceId"));
		absenceetudiant.setJustification(rs.getBoolean("Justification"));
		absenceetudiant.setMotif(rs.getString("Motif"));
		
		Etudiant etudiant=new Etudiant();
		etudiant.setId(rs.getInt("EtudiantID"));
		etudiant.setTitre(rs.getString("Titre"));
		etudiant.setSexe(rs.getString("Sexe"));
		etudiant.setCin(rs.getString("Cin"));
		etudiant.setNom_Fr(rs.getString("Nom_Fr"));
		etudiant.setPrenom_Fr(rs.getString("Prenom_Fr"));
		etudiant.setNom_Ar(rs.getString("Nom_Ar"));
		etudiant.setPrenom_Ar(rs.getString("Prenom_Ar"));
		etudiant.setNationalite(rs.getString("Nationalite"));
		etudiant.setDateNais(rs.getDate("DateNais"));
		etudiant.setLieuNais_Fr(rs.getString("LieuNais_Fr"));
		etudiant.setLieuNais_Ar(rs.getString("LieuNais_Ar"));
		etudiant.setAdresse_Fr(rs.getString("Adresse_Fr"));
		etudiant.setAdresse_Ar(rs.getString("Adresse_Ar"));
		etudiant.setEmail(rs.getString("Email"));
		etudiant.setSituationF(rs.getString("SituationF"));
		etudiant.setTeleMobile(rs.getString("TeleMobile"));
		etudiant.setTeleDomicile(rs.getString("TeleDomicile"));
		etudiant.setCne(rs.getString("Cne"));
		etudiant.setNumInscription(rs.getString("NumInscription"));
		etudiant.setAnneeBac(rs.getString("AnneeBac"));
		etudiant.setMoyenneBac(rs.getFloat("MoyenneBac"));
		etudiant.setCandidat(rs.getString("Candidat"));
		etudiant.setEtat(rs.getString("Etat"));
		etudiant.setPhoto(rs.getString("Photo"));
		
		OptionBac optionBac = new OptionBac();
		optionBac.setId(rs.getInt("OptionBacID"));
		optionBac.setCode(rs.getString("OptionBacCode"));
		optionBac.setNom_Fr(rs.getString("OptionBacNom_Fr"));
		optionBac.setNom_Ar(rs.getString("OptionBacNom_Ar"));
		etudiant.setOptionBac(optionBac);
		
		Mention mentionBac = new Mention();
		mentionBac.setId(rs.getInt("MentionBacID"));
		mentionBac.setCode(rs.getString("MentionBacCode"));
		mentionBac.setNom_Fr(rs.getString("MentionBacNom_Fr"));
		mentionBac.setNom_Ar(rs.getString("MentionBacNom_Ar"));
		etudiant.setMentionBac(mentionBac);
		
		Filiere filiere = new Filiere();
		filiere.setId(rs.getInt("FiliereID"));
		filiere.setCode(rs.getString("FiliereCode"));
		filiere.setNom_Fr(rs.getString("FiliereNom_Fr"));
		filiere.setNom_Ar(rs.getString("FiliereNom_Ar"));
		etudiant.setFiliere(filiere);
		
		Etablissement etablissement = new Etablissement();
		etablissement.setId(rs.getInt("EtablissementID"));
		etablissement.setCode(rs.getString("EtablissementCode"));
		etablissement.setNom_Fr(rs.getString("EtablissementNom_Fr"));
		etablissement.setNom_Ar(rs.getString("EtablissementNom_Ar"));
		etablissement.setAdresse_Fr(rs.getString("EtablissementAdresse_Fr"));
		etablissement.setAdresse_Ar(rs.getString("EtablissementAdresse_Ar"));
		etablissement.setTelephone(rs.getString("EtablissementTel"));
		etablissement.setEmail(rs.getString("EtablissementEmail"));
		
		Parent parent=new Parent();
		parent.setId(rs.getInt("ParentID"));
		parent.setTitre(rs.getString("TitreParent"));
		parent.setSexe(rs.getString("SexeParent"));
		parent.setCin(rs.getString("CinParent"));
		parent.setNom_Fr(rs.getString("Nom_FrParent"));
		parent.setPrenom_Fr(rs.getString("Prenom_FrParent"));
		parent.setNom_Ar(rs.getString("Nom_ArParent"));
		parent.setPrenom_Ar(rs.getString("Prenom_ArParent"));
		parent.setNationalite(rs.getString("NationaliteParent"));
		parent.setDateNais(rs.getDate("DateNaisParent"));
		parent.setLieuNais_Fr(rs.getString("LieuNais_FrParent"));
		parent.setLieuNais_Ar(rs.getString("LieuNais_ArParent"));
		parent.setAdresse_Fr(rs.getString("Adresse_FrParent"));
		parent.setAdresse_Ar(rs.getString("Adresse_ArParent"));
		parent.setEmail(rs.getString("EmailParent"));
		parent.setSituationF(rs.getString("SituationFParent"));
		parent.setTeleMobile(rs.getString("TeleMobileParent"));
		parent.setTeleDomicile(rs.getString("TeleDomicileParent"));
		parent.setPhoto(rs.getString("PhotoParent"));
		parent.setLienParente(rs.getString("LienParente"));
		etudiant.setParent(parent);
		
		absenceetudiant.setEtudiant(etudiant);
		
		SeanceGenerique seancegenerique=new SeanceGenerique();
		Seance seance=new Seance();
		seancegenerique.setId(rs.getInt("seancegeneriqueID"));
		seancegenerique.setJour(rs.getString("Jour"));
		seancegenerique.setHeureDebut(rs.getString("HeureDebut"));
		seancegenerique.setHeureFin(rs.getString("HeureFin"));
		seancegenerique.setDuree(rs.getShort("Duree"));
		seancegenerique.setObservation(rs.getString("Observation"));
		
		seance.setSeanceGenerique(seancegenerique);
		
	  seance.setId(rs.getInt("SeanceID"));
	  seance.setDate(rs.getDate("Date"));
	  seance.setEtat(rs.getString("Etat"));
	  seance.setObservation(rs.getString("Observation"));
	  
	  absenceetudiant.setSeance(seance);
	  
	  DocJustifAbsEtudiant docjustifabs=new DocJustifAbsEtudiant();
	  docjustifabs.setId(rs.getInt("justifabsID"));
	  docjustifabs.setCode(rs.getString("Code"));
	  docjustifabs.setNom(rs.getString("Nom"));
	  docjustifabs.setDateDepot(rs.getDate("DateDepot"));
	  docjustifabs.setDateDebut(rs.getDate("DateDebut"));
	  docjustifabs.setDateFin(rs.getDate("DateFin"));
	  docjustifabs.setDateUpload(rs.getDate("DateUpload"));
	  docjustifabs.setEmplacement(rs.getString("Emplacement"));
	  docjustifabs.setType(rs.getString("Type"));
	  docjustifabs.setTaille(rs.getLong("Taille"));
	  docjustifabs.setObservation(rs.getString("Observation"));
	  
	  absenceetudiant.setDocumentJustificatif(docjustifabs);
	  
	  //remplissage du arraylist
	  absetd.add(absenceetudiant);
	  }
	
	rs.close();
	statement.close();
	return absetd;
}
public static ArrayList<AbsenceEtudiant> getAllByEtd(int id) throws SQLException{
	String req="select absenceetudiant.id ,`utilisateur`.`Nom_Fr`, `utilisateur`.`Prenom_Fr`,`utilisateur`.`ID`,etudiant.FiliereID,`matiere`.`Nom_FR`,seance.date,seanceGenerique.jour,seanceGenerique.heureDebut,seanceGenerique.heureFIn,seanceGenerique.Duree  from absenceetudiant,etudiant,utilisateur,seance,seancegenerique,matiere where `etudiant`.`UtilisateurID` = `utilisateur`.`ID` and `absenceetudiant`.`EtudiantUtilisateurID`= `etudiant`.`UtilisateurID` AND `absenceetudiant`.`SeanceID`= `seance`.`ID` and `matiere`.`ID`=`seancegenerique`.`ID` and seancegenerique.ID=`seance`.`SeanceGeneriqueID` and   `utilisateur`.`ID`=?;";
	PreparedStatement statement = (PreparedStatement) con.prepareStatement(req);
	statement.setInt(1, id);;
	ResultSet rs = statement.executeQuery();
	ArrayList<AbsenceEtudiant> absetde=new ArrayList<AbsenceEtudiant>();
	AbsenceEtudiant absenceetudiant =null;
	while(rs.next()) {
		absenceetudiant=new AbsenceEtudiant();
		
		Seance seance=new Seance();
		 seance.setId(rs.getInt("ID"));
		 SeanceGenerique sg=new SeanceGenerique();
		 sg.setJour(rs.getString("seanceGenerique.jour"));
		 sg.setHeureDebut(rs.getString("seanceGenerique.heureDebut"));
		 sg.setHeureFin(rs.getString("seanceGenerique.heureFin"));
		 sg.setDuree(Short.parseShort(rs.getString("seanceGenerique.duree")));
		 Matiere m =new Matiere();
		 m.setNom_Fr(rs.getString("matiere.Nom_Fr"));
		 sg.setMatiere(m);
		 seance.setDate(rs.getDate("seance.date"));
		 seance.setSeanceGenerique(sg);
		 absenceetudiant.setSeance(seance);
		Etudiant etudiant=new Etudiant();
		etudiant.setNom_Fr(rs.getString("utilisateur.Nom_Fr"));
		etudiant.setPrenom_Fr(rs.getString("Prenom_Fr"));
		Filiere f=new Filiere();
		f.setId(rs.getInt("FiliereID"));
		etudiant.setFiliere(f);
		absenceetudiant.setId(rs.getInt("id"));
		absenceetudiant.setEtudiant(etudiant);
		absetde.add(absenceetudiant);
	}
	rs.close();
	statement.close();
	return absetde;
	}
public static ArrayList<AbsenceEtudiant> getAlletd() throws SQLException{
	String req="select absenceetudiant.id ,seanceGenerique.ClasseID,classegenerique.ID,`utilisateur`.`Nom_Fr`, `utilisateur`.`Prenom_Fr`,`utilisateur`.`ID`,etudiant.FiliereID,`matiere`.`Nom_FR`,seance.date,seanceGenerique.jour,seanceGenerique.heureDebut,seanceGenerique.heureFIn,seanceGenerique.Duree  from absenceetudiant,etudiant,utilisateur,seance,seancegenerique,matiere,classegenerique,classe where `etudiant`.`UtilisateurID` = `utilisateur`.`ID` and `absenceetudiant`.`EtudiantUtilisateurID`= `etudiant`.`UtilisateurID` AND `absenceetudiant`.`SeanceID`= `seance`.`ID` and `matiere`.`ID`=`seancegenerique`.`ID` and seancegenerique.ID=`seance`.`SeanceGeneriqueID` and seancegenerique.ClasseID=classe.ID and classe.classegeneriqueID=classegenerique.ID;";
	PreparedStatement statement = (PreparedStatement) con.prepareStatement(req);
	ResultSet rs = statement.executeQuery();
	ArrayList<AbsenceEtudiant> absetde=new ArrayList<AbsenceEtudiant>();
	AbsenceEtudiant absenceetudiant =null;
	while(rs.next()) {
		absenceetudiant=new AbsenceEtudiant();
		
		Seance seance=new Seance();
		 seance.setId(rs.getInt("ID"));
		 SeanceGenerique sg=new SeanceGenerique();
		 Classe c=new Classe();
		 ClasseGenerique cg=new ClasseGenerique();
		 cg.setId(rs.getInt("classegenerique.ID"));
		 cg.setNiveau(new Niveau());
		 cg.setCycle(new Cycle());
		 cg.setFiliere(new Filiere());
		 c.setClasseGenerique(cg);
		 c.setAnneeScolaire(new AnneeScolaire());
		 sg.setClasse(c);
		 sg.setJour(rs.getString("seanceGenerique.jour"));
		 sg.setHeureDebut(rs.getString("seanceGenerique.heureDebut"));
		 sg.setHeureFin(rs.getString("seanceGenerique.heureFin"));
		 sg.setDuree(Short.parseShort(rs.getString("seanceGenerique.duree")));
		 Matiere m =new Matiere();
		 m.setNom_Fr(rs.getString("matiere.Nom_Fr"));
		 sg.setMatiere(m);
		 
		 seance.setDate(rs.getDate("seance.date"));
		 seance.setSeanceGenerique(sg);
		 absenceetudiant.setSeance(seance);
		Etudiant etudiant=new Etudiant();
		etudiant.setNom_Fr(rs.getString("utilisateur.Nom_Fr"));
		etudiant.setPrenom_Fr(rs.getString("Prenom_Fr"));
		Filiere f=new Filiere();
		f.setId(rs.getInt("FiliereID"));
		etudiant.setFiliere(f);
		absenceetudiant.setId(rs.getInt("id"));
		absenceetudiant.setEtudiant(etudiant);
		absetde.add(absenceetudiant);
	}
	rs.close();
	statement.close();
	return absetde;
	}
public static ArrayList<AbsenceEtudiant> getAllByFil(int id) throws SQLException{
	String req="select absenceetudiant.id ,`utilisateur`.`Nom_Fr`, `utilisateur`.`Prenom_Fr`,etudiant.FiliereID,`matiere`.`Nom_FR`,seance.date,seanceGenerique.jour,seanceGenerique.heureDebut,seanceGenerique.heureFIn from absenceetudiant,etudiant,utilisateur,seance,seancegenerique,matiere,classe where `etudiant`.`UtilisateurID` = `utilisateur`.`ID` and `absenceetudiant`.`EtudiantUtilisateurID`= `etudiant`.`UtilisateurID` AND `absenceetudiant`.`SeanceID`= `seance`.`ID` and `matiere`.`ID`=`seancegenerique`.`ID` and seancegenerique.ID=`seance`.`ID` and seancegenerique.ClasseID=classe.ID and seancegenerique.FiliereID=?;";
	PreparedStatement statement = (PreparedStatement) con.prepareStatement(req);
	statement.setInt(1, id);
	ResultSet rs = statement.executeQuery();
	ArrayList<AbsenceEtudiant> absetde=new ArrayList<AbsenceEtudiant>();
	AbsenceEtudiant absenceetudiant =null;
	while(rs.next()) {
		absenceetudiant=new AbsenceEtudiant();
		
		Seance seance=new Seance();
		 seance.setId(rs.getInt("ID"));
		 SeanceGenerique sg=new SeanceGenerique();
		 sg.setJour(rs.getString("seanceGenerique.jour"));
		 sg.setHeureDebut(rs.getString("seanceGenerique.heureDebut"));
		 sg.setHeureFin(rs.getString("seanceGenerique.heureFin"));
		 Matiere m =new Matiere();
		 m.setNom_Fr(rs.getString("matiere.Nom_Fr"));
		 sg.setMatiere(m);
		 
		 seance.setDate(rs.getDate("seance.date"));
		 seance.setSeanceGenerique(sg);
		 absenceetudiant.setSeance(seance);
		Etudiant etudiant=new Etudiant();
		etudiant.setNom_Fr(rs.getString("utilisateur.Nom_Fr"));
		etudiant.setPrenom_Fr(rs.getString("Prenom_Fr"));
		Filiere f=new Filiere();
		f.setId(rs.getInt("FiliereID"));
		etudiant.setFiliere(f);
		absenceetudiant.setId(rs.getInt("id"));
		absenceetudiant.setEtudiant(etudiant);
		absetde.add(absenceetudiant);
	}
	rs.close();
	statement.close();
	return absetde;
	}
public static ArrayList<AbsenceEtudiant> getAllByDate(int id,Date d) throws SQLException{
	String req="select absenceetudiant.id ,`utilisateur`.`Nom_Fr`, `utilisateur`.`Prenom_Fr`,etudiant.FiliereID,`matiere`.`Nom_FR`,seance.date,seanceGenerique.jour,seanceGenerique.heureDebut,seanceGenerique.heureFIn from absenceetudiant,etudiant,utilisateur,seance,seancegenerique,matiere,classe where `etudiant`.`UtilisateurID` = `utilisateur`.`ID` and `absenceetudiant`.`EtudiantUtilisateurID`= `etudiant`.`UtilisateurID` AND `absenceetudiant`.`SeanceID`= `seance`.`ID` and `matiere`.`ID`=`seancegenerique`.`ID` and seancegenerique.ID=`seance`.`ID` and seancegenerique.ClasseID=classe.ID and seancegenerique.ClasseID=? and seance.date=?;";
	PreparedStatement statement = (PreparedStatement) con.prepareStatement(req);
	statement.setInt(1, id);
	statement.setDate(2, d);
	ResultSet rs = statement.executeQuery();
	ArrayList<AbsenceEtudiant> absetde=new ArrayList<AbsenceEtudiant>();
	AbsenceEtudiant absenceetudiant =null;
	while(rs.next()) {
		absenceetudiant=new AbsenceEtudiant();
		
		Seance seance=new Seance();
		 seance.setId(rs.getInt("ID"));
		 SeanceGenerique sg=new SeanceGenerique();
		 
		 sg.setJour(rs.getString("seanceGenerique.jour"));
		 sg.setHeureDebut(rs.getString("seanceGenerique.heureDebut"));
		 sg.setHeureFin(rs.getString("seanceGenerique.heureFin"));
		 Matiere m =new Matiere();
		 m.setNom_Fr(rs.getString("matiere.Nom_Fr"));
		 sg.setMatiere(m);
		 
		 seance.setDate(rs.getDate("seance.date"));
		 seance.setSeanceGenerique(sg);
		 absenceetudiant.setSeance(seance);
		Etudiant etudiant=new Etudiant();
		etudiant.setNom_Fr(rs.getString("utilisateur.Nom_Fr"));
		etudiant.setPrenom_Fr(rs.getString("Prenom_Fr"));
		Filiere f=new Filiere();
		f.setId(rs.getInt("FiliereID"));
		etudiant.setFiliere(f);
		absenceetudiant.setId(rs.getInt("id"));
		absenceetudiant.setEtudiant(etudiant);
		absetde.add(absenceetudiant);
	}
	rs.close();
	statement.close();
	return absetde;
	}

public AbsenceEtudiant getById(int id) throws SQLException{
	String req="select * from absenceetudiant where `absenceetudiant`.id="+id+";";
	PreparedStatement statement = (PreparedStatement) con.prepareStatement(req);
	ResultSet rs = statement.executeQuery();
	AbsenceEtudiant absenceetudiant =null;
	while(rs.next()) {
		absenceetudiant=new AbsenceEtudiant();
		
		absenceetudiant.setId(rs.getInt("id"));
		absenceetudiant.setJustification(rs.getBoolean("justification"));
		absenceetudiant.setMotif(rs.getString("motif"));
		DocJustifAbsEtudiant d= new DocJustifAbsEtudiant();
		d.setId(rs.getInt("DocJustifAbsEtudiantID"));
		absenceetudiant.setDocumentJustificatif(d);
	}
	rs.close();
	statement.close();
	return absenceetudiant;
	}
public static void update (AbsenceEtudiant absenceetudiant) throws SQLException{
	PreparedStatement statement = (PreparedStatement) con.prepareStatement("update AbsenceEtudiant set Justification = ?, Motif = ?  where ID = ?");
	statement.setBoolean(1, absenceetudiant.getJustification());
	statement.setString(2, absenceetudiant.getMotif());
	statement.setInt(3,absenceetudiant.getId());
	statement.execute();
}

public static ArrayList<AbsenceEtudiant> getNbreAbs()throws SQLException{
	try {
		String req="select * from absenceetudiant";
		PreparedStatement st=(PreparedStatement) con.prepareStatement(req);
		ResultSet rs=st.executeQuery();
	ArrayList<AbsenceEtudiant> abse=new ArrayList();
		while(rs.next()) {
			AbsenceEtudiant	absetd=new AbsenceEtudiant();
			absetd.setId(rs.getInt("id"));
	absetd.setJustification(rs.getBoolean("justification"));
		abse.add(absetd);
		}
		rs.close();
		return abse;
	} catch (Exception e) {
		return null;
	}
	
}
public static ArrayList<Statistiques> getEtdStatistiques() throws SQLException{
	String req="select count(absenceetudiant.id)AS C,absenceetudiant.id ,`utilisateur`.`Nom_Fr`, `utilisateur`.`Prenom_Fr`,`utilisateur`.`ID`,etudiant.FiliereID,`matiere`.`Nom_FR`,seance.date,seanceGenerique.jour,seanceGenerique.heureDebut,seanceGenerique.heureFIn,seanceGenerique.Duree  from absenceetudiant,etudiant,utilisateur,seance,seancegenerique,matiere where `etudiant`.`UtilisateurID` = `utilisateur`.`ID` and `absenceetudiant`.`EtudiantUtilisateurID`= `etudiant`.`UtilisateurID` AND `absenceetudiant`.`SeanceID`= `seance`.`ID` and `matiere`.`ID`=`seancegenerique`.`ID` and seancegenerique.ID=`seance`.`SeanceGeneriqueID` group by(`utilisateur`.`ID`);";
	PreparedStatement statement = (PreparedStatement) con.prepareStatement(req);
	ResultSet rs = statement.executeQuery();
	ArrayList<Statistiques> absetde=new ArrayList<Statistiques>();
	AbsenceEtudiant absenceetudiant =null;
	while(rs.next()) {
		absenceetudiant=new AbsenceEtudiant();
		Statistiques stat=new Statistiques();
		Seance seance=new Seance();
		 seance.setId(rs.getInt("ID"));
		 SeanceGenerique sg=new SeanceGenerique();
		 sg.setJour(rs.getString("seanceGenerique.jour"));
		 sg.setHeureDebut(rs.getString("seanceGenerique.heureDebut"));
		 sg.setHeureFin(rs.getString("seanceGenerique.heureFin"));
		 sg.setDuree(Short.parseShort(rs.getString("seanceGenerique.duree")));
		 Matiere m =new Matiere();
		 m.setNom_Fr(rs.getString("matiere.Nom_Fr"));
		 sg.setMatiere(m);
		 
		 seance.setDate(rs.getDate("seance.date"));
		 seance.setSeanceGenerique(sg);
		 absenceetudiant.setSeance(seance);
		Etudiant etudiant=new Etudiant();
		etudiant.setId(rs.getInt("utilisateur.id"));
		etudiant.setNom_Fr(rs.getString("utilisateur.Nom_Fr"));
		etudiant.setPrenom_Fr(rs.getString("Prenom_Fr"));
		Filiere f=new Filiere();
		f.setId(rs.getInt("FiliereID"));
		etudiant.setFiliere(f);
		absenceetudiant.setId(rs.getInt("id"));
		absenceetudiant.setEtudiant(etudiant);
	stat.setNbreabs(rs.getInt("C"));
		stat.setAbs(absenceetudiant);
		stat.setE(etudiant);
		absetde.add(stat);
	}
	rs.close();
	statement.close();
	return absetde;
	}
}