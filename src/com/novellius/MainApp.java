package com.novellius;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.novellius.dao.AdminDao;
import com.novellius.pojo.Admin;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");
		

			AdminDao adminDao = (AdminDao) applicationContext.getBean("adminDao");
			
			Timestamp ts= new Timestamp(new Date().getTime());
			
			/*Admin admin = new Admin();
			admin.setCargo("sub-gerente");
			admin.setNombre("martin");
			admin.setFechaCreacion(ts);*/
			/*adminDao.save(admin);
			List<Admin> admins= adminDao.findAll();
			for(Admin admin2:admins) {
				System.out.println(admin2);
			}
			System.out.println(adminDao.findById(1));
			System.out.println(adminDao.findById(3));
			System.out.println(adminDao.findByNombre("j").toString()); */	
				
				/*Admin admin= adminDao.findById(1);
				
				System.out.println("Admin con Id 1:"+ admin);
				
				admin.setCargo("soldado");
				admin.setNombre("miguel"); 
				
				if(adminDao.update(admin)){
					System.out.println("Actualizado correctamente: "+admin);
				}
				
				if(adminDao.delete(admin.getIdAd())) {
					System.out.println("Amin: "+admin.getNombre()+" eliminado correctamente");
				}*/
			try {
				List<Admin> admins= new ArrayList<Admin>();
				admins.add(new Admin(30,"pedro", "jefe de ingenieria", ts));
				admins.add(new Admin(31,"Ana Maria", "sub-jefe de ingenieria", ts));
				admins.add(new Admin(32,"Carlos", "desarrollador", ts));
				
				int[] vals= adminDao.saveAll(admins);
				
				for(int i : vals) {
					System.out.println("filas afectadas para la operacion: "+i);
				}
			} catch(CannotGetJdbcConnectionException ex){
				ex.printStackTrace();
			}catch(DataAccessException ex){
				ex.printStackTrace();
			}
		((ClassPathXmlApplicationContext)applicationContext).close();
		
	}

}


/*

		Admin administrador= (Admin) applicationContext.getBean("admin");
		
		System.out.println(administrador);
		//administrador.imprimirDireccion();

*/