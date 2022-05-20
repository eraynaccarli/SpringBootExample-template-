package kodlamaio.northwind.core.utilities.results;

public class SuccessDataResult<T> extends DataResult {

	// işlem başarılıysa data true ve message bilgisi dondur 
	public SuccessDataResult(Object data, String message) {
		super(data, true , message);
	}
	
	//sadece data bilgisi dondur
	public SuccessDataResult(T data) {
		super(data,true);
	}
	
	// sadece mesaj bilgisi dondur
	public SuccessDataResult(String message) {
		super(null,true,message);
	}
	
	// hiç data vermezsen null ve true döndürürüm
	public SuccessDataResult() {
		super(null,true);
	}
	

}
