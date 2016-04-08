package myJena;

import java.lang.*;
import java.util.regex.*;
import java.io.*;
import com.hp.hpl.jena.sparql.*;
import com.hp.hpl.jena.*;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.query.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDFS;

import edu.stanford.smi.protegex.owl.ProtegeOWL;
import edu.stanford.smi.protegex.owl.jena.JenaOWLModel;
import edu.stanford.smi.protegex.owl.model.OWLModel;


public class MyFirstSparql {
public static void main(String[] args) throws FileNotFoundException, IOException,           NullPointerException {

try
{
    //opening owl file
    //InputStream in = new FileInputStream(new  File("C:/Users/Sandhya/Desktop/Ontology/newtamil.owl"));
    InputStream in = new FileInputStream(new  File("/home/tony/newTraffic.owl"));
    Model model=ModelFactory.createMemModelMaker().createDefaultModel() ;
    model.read(in,null);       
  System.out.println(model);
   in.close();
   String queryString =
    "PREFIX uri:   <http://www.enigmatix.eu5.org/newTraffic.owl#> "+     

  " PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "+
     "PREFIX owl: <http://www.w3.org/2002/07/owl#> "+
     "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "+
     "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "+
   //  "SELECT ?subject ?object "+
     //"  WHERE { ?subject rdfs:subClassOf ?object }";*/
		   
		   "SELECT ?x ?vehicleCount " +
		   "WHERE {?x  <http://www.enigmatix.eu5.org/newTraffic.owl#vehicleCount>  ?vehicleCount}" ;
    com.hp.hpl.jena.query.Query q = QueryFactory.create(queryString);
    QueryExecution qe = QueryExecutionFactory.create(q, model);
    ResultSet results = qe.execSelect();
    while (results.hasNext())
    {
        System.out.println(results.getResourceModel() );

    ResultSetFormatter.out(System.out, results, q);
    qe.close();
    }
   }catch(java.lang.NullPointerException e){ System.out.println(e);}
    catch(Exception e){
  System.out.println("Query Failed !");
    }

   }

   }