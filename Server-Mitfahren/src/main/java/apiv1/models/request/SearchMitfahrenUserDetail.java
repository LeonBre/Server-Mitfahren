package apiv1.models.request;

import apiv1.models.DataBody;

public class SearchMitfahrenUserDetail extends DataBody{

	public String userId;
	
	public SearchMitfahrenUserDetail(){}
	
	public SearchMitfahrenUserDetail(String userId) {
		this.userId = userId;
	}
}
