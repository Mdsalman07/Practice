package DeserializingPojoForGetCall;

import java.util.List;

public class ListUsersPOJO {
	
	// Below JSON One Going to DeseriaLize
	//Copy the Below JSON in CodeBeautify to know the object of JSON to create POJO Classes
	
//	{
//	    "page": 2,
//	    "per_page": 6,
//	    "total": 12,
//	    "total_pages": 2,
//	    "data": [
//	        {
//	            "id": 7,
//	            "email": "michael.lawson@reqres.in",
//	            "first_name": "Michael",
//	            "last_name": "Lawson",
//	            "avatar": "https://reqres.in/img/faces/7-image.jpg"
//	        },
//	        {
//	            "id": 8,
//	            "email": "lindsay.ferguson@reqres.in",
//	            "first_name": "Lindsay",
//	            "last_name": "Ferguson",
//	            "avatar": "https://reqres.in/img/faces/8-image.jpg"
//	        },
//	        {
//	            "id": 9,
//	            "email": "tobias.funke@reqres.in",
//	            "first_name": "Tobias",
//	            "last_name": "Funke",
//	            "avatar": "https://reqres.in/img/faces/9-image.jpg"
//	        },
//	        {
//	            "id": 10,
//	            "email": "byron.fields@reqres.in",
//	            "first_name": "Byron",
//	            "last_name": "Fields",
//	            "avatar": "https://reqres.in/img/faces/10-image.jpg"
//	        },
//	        {
//	            "id": 11,
//	            "email": "george.edwards@reqres.in",
//	            "first_name": "George",
//	            "last_name": "Edwards",
//	            "avatar": "https://reqres.in/img/faces/11-image.jpg"
//	        },
//	        {
//	            "id": 12,
//	            "email": "rachel.howell@reqres.in",
//	            "first_name": "Rachel",
//	            "last_name": "Howell",
//	            "avatar": "https://reqres.in/img/faces/12-image.jpg"
//	        }
//	    ],
//	    "support": {
//	        "url": "https://reqres.in/#support-heading",
//	        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
//	    }
//	}
	
             private String page;
             private String per_page;
             private String total;
             private String total_pages;
             private List<DataPojo> data;
             private SupportPojo support;
			public String getPage() {
				return page;
			}
			public void setPage(String page) {
				this.page = page;
			}
			public String getPer_page() {
				return per_page;
			}
			public void setPer_page(String per_page) {
				this.per_page = per_page;
			}
			public String getTotal() {
				return total;
			}
			public void setTotal(String total) {
				this.total = total;
			}
			public String getTotal_pages() {
				return total_pages;
			}
			public void setTotal_pages(String total_pages) {
				this.total_pages = total_pages;
			}
			public List<DataPojo> getData() {
				return data;
			}
			public void setData(List<DataPojo> data) {
				this.data = data;
			}
			public SupportPojo getSupport() {
				return support;
			}
			public void setSupport(SupportPojo support) {
				this.support = support;
			}
			
			
			@Override
			public String toString() {
				return "ListUsersPOJO [page=" + page + ", per_page=" + per_page + ", total=" + total + ", total_pages="
						+ total_pages + ", data=" + data + ", support=" + support + "]";
			}
			
			
			
             
             
}
