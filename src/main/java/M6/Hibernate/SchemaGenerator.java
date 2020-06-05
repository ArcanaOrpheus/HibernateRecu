package M6.Hibernate;

import java.io.File;
import java.util.EnumSet;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
 

public class SchemaGenerator {

	//Clase que genera la base de dades a mysql y crea el script sql
	
	public static final String SQL_Script = "databse.sql";
	
	private static SchemaExport getSchemaExport() {
		SchemaExport export = new SchemaExport();
		File outputFile = new File(SQL_Script);
		String outputFilePath = outputFile.getAbsolutePath();
		
		System.out.println("Exporting file: " + outputFilePath);
		
		export.setDelimiter(";");
		export.setOutputFile(outputFilePath);
		
		//Si hi ha un error aixo impedeix que pari
		export.setHaltOnError(false);
		return export;
		
	}
	
	public static void dropDatabase(SchemaExport export, Metadata metadata) {
		//TargetType.Database executes on db
		//TargetType.Script writes the script file
		//TargetType.STDOUT writes on the console
		EnumSet<TargetType> targetTypes = EnumSet.of(TargetType.DATABASE, TargetType.SCRIPT, TargetType.STDOUT);
		export.drop(targetTypes, metadata);
		System.out.println("Droped database succesfully");
	}
	
	public static void createDatabase(SchemaExport export, Metadata metadata) {
		  EnumSet<TargetType> targetTypes = EnumSet.of(TargetType.DATABASE, TargetType.SCRIPT, TargetType.STDOUT);
		  //Point to the action we hace too do
	       SchemaExport.Action action = SchemaExport.Action.CREATE;
	       export.execute(targetTypes, action, metadata);
	 
	       System.out.println("Created OK");
	}
	
	public static void execute() {
		System.out.println("HI");
		ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    	Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
    	SchemaExport export = SchemaGenerator.getSchemaExport();
    	System.out.println("Drop database...");
    	dropDatabase(export, metadata);
    	System.out.println("Creating database...");
    	createDatabase(export, metadata);
	}
	
}
