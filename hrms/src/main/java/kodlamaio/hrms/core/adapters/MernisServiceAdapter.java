package kodlamaio.hrms.core.adapters;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter /*implements IdentityService*/{

	//@Override
	public boolean checkIfRealPerson(JobSeeker jobSeeker) {
	
		KPSPublicSoap soapClient = new KPSPublicSoapProxy();
		boolean result = false ;
		
		try {
			result = soapClient.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getIdentificationNumber()), 
					jobSeeker.getFirstName(), 
					jobSeeker.getLastName(), 
					Integer.parseInt(jobSeeker.getYearOfBirth())) ;
		}
		catch (NumberFormatException e) {
			   e.printStackTrace();
		} 
		catch (RemoteException e) {
		       e.printStackTrace();
	    }
	
		return result;	
	
	}

}
