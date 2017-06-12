package DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import modell.Categorie;
import modell.Contact;


public class ContactDAO {
		/** Add Contact
		 * @param categorie **/
		public void addContact(String nom,String prenom,String num_tel,String type_tel, int id_categorie) {
			// 1. configuring hibernate
			Configuration configuration = new Configuration().configure();

			// 2. create sessionfactory
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			 // 3. Get Session objects
			Session session = sessionFactory.openSession();
			// 4. Starting Transaction
			Transaction transaction = session.beginTransaction();

			try {
				
				
				Contact c = new Contact();

				c.setNom(nom);
				c.setPrenom(prenom);
				c.setNum_tel(num_tel);
				c.setType_tel(type_tel);
				c.setId_categorie(id_categorie);;

				session.save(c);
				transaction.commit();
				session.close();
				System.out.println("\n\n Details Added \n");

			} catch (HibernateException e) {
				System.out.println(e.getMessage());
				System.out.println("error");
			}
		}

		/** Show Contact **/
		public static List List_of_Contact() {
			// 1. configuring hibernate
			Configuration configuration = new Configuration().configure();

			// 2. create sessionfactory
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			 // 3. Get Session objects
			Session session = sessionFactory.openSession();
			List data = null;
			try {
			
				org.hibernate.query.Query query = session.createQuery("from Contact");

				data = query.list();
			} catch (Exception e) {
				System.out.println(e.getMessage());

			}
			return data;
		}
		
		/** Show Contact **/
		public static List  ListCategorie() {
			// 1. configuring hibernate
			Configuration configuration = new Configuration().configure();

			// 2. create sessionfactory
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			 // 3. Get Session objects
			Session session = sessionFactory.openSession();
			List data = null;
			try {
			
				org.hibernate.query.Query query = session.createQuery("from Categorie");

				data = query.list();
			} catch (Exception e) {
				System.out.println(e.getMessage());

			}
			return data;
		}
//ajouter une nouvelle Categorie 
		public void AddCategorie(String categorie) {
			// TODO Auto-generated method stub
			
			
				// 1. configuring hibernate
				Configuration configuration = new Configuration().configure();

				// 2. create sessionfactory
				SessionFactory sessionFactory = configuration.buildSessionFactory();
				 // 3. Get Session objects
				Session session = sessionFactory.openSession();
				// 4. Starting Transaction
				Transaction transaction = session.beginTransaction();

				try {
					
					
					Categorie c = new Categorie();

					c.setNom_categorie(categorie);;
					

					session.save(c);
					transaction.commit();
					session.close();
					System.out.println("\n\n Details Added \n");

				} catch (HibernateException e) {
					System.out.println(e.getMessage());
					System.out.println("error");
				}
		}

//Afficher la liste des contacts par categorie:
		public static List List_Par_Categorie(int IdCategorie) {
			// 1. configuring hibernate
			Configuration configuration = new Configuration().configure();

			// 2. create sessionfactory
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			 // 3. Get Session objects
			Session session = sessionFactory.openSession();
			List data = null;
			try {
			
				org.hibernate.query.Query query = session.createQuery("from Contact where id_categorie=:IdCategorie");
query.setParameter("IdCategorie", IdCategorie);
				data = query.list();
			} catch (Exception e) {
				System.out.println(e.getMessage());

			}
			return data;
		}
		
		//Modifier un contact
		
		public void UpdateContact( String nom, String prenom,
				String num_tel, String type_tel,  int id_categorie ,int id_contact) {

			try {
				// 1. configuring hibernate
				Configuration configuration = new Configuration().configure();

				// 2. create sessionfactory
				SessionFactory sessionFactory = configuration.buildSessionFactory();
				 // 3. Get Session objects
				Session session = sessionFactory.openSession();
				// 4. Starting Transaction
				Transaction transaction = session.beginTransaction();

			
				Query query = session.createQuery("UPDATE Contact SET nom= :nom,prenom= :prenom,num_tel= :num_tel,type_tel=:type_tel,id_categorie= :id_categorie WHERE id_contact = :id_contact");
				query.setParameter("nom", nom);
						
				query.setParameter("prenom", prenom);
				query.setParameter("num_tel", num_tel);
				query.setParameter("type_tel", type_tel);
				query.setParameter("id_categorie", id_categorie);

				query.setParameter("id_contact", id_contact);

				int i = query.executeUpdate();
				transaction.commit();
				session.close();
				System.out.println("\n\n Details update \n"+i);

			} catch (Exception e) {
				System.out.println(e.getMessage());

			}

		}
		
		
		
		public void DeleteContact(  int id_contact ) {

			try {
				// 1. configuring hibernate
				Configuration configuration = new Configuration().configure();

				// 2. create sessionfactory
				SessionFactory sessionFactory = configuration.buildSessionFactory();
				 // 3. Get Session objects
				Session session = sessionFactory.openSession();
				// 4. Starting Transaction
				Transaction transaction = session.beginTransaction();

			
				Query query = session.createQuery("DELETE from Contact WHERE id_contact = :id_contact");
				query.setParameter("id_contact", id_contact);
				

				int i = query.executeUpdate();
				transaction.commit();
				session.close();
				System.out.println("\n\n Details update \n"+i);

			} catch (Exception e) {
				System.out.println(e.getMessage());

			}

		}
		
}
