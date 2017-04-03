package com.neusoft.cargo.action;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.cargo.entity.Car;
import com.neusoft.cargo.entity.CargoResource;
import com.neusoft.cargo.entity.TrackOrder;
import com.neusoft.cargo.service.CarService;
import com.neusoft.cargo.service.CargoResourceService;
import com.neusoft.cargo.service.TrackOrderService;
import com.neusoft.cargo.service.UserService;
import com.sun.xml.internal.bind.v2.TODO;

@Controller("BookResourceAction")
public class BookResource extends Base {

	Logger logger = Logger.getLogger(BookResource.class);

	@Autowired
	private UserService userservice;
	@Autowired
	private CarService carService;
	@Autowired
	private CargoResourceService cargoResourceService;
	@Autowired
	private TrackOrderService trackOrderService;

	
	// ${pageContext.request.contextPath}/person/updatePersonList.action"
	@RequestMapping(value = "bookresource.do", method = RequestMethod.GET)
	public String bookresource(String idname, Model model) {
		// JsonParameter
		List<Car> cl = userservice.GetCarList(getUser());

		CargoResource cargoResource = cargoResourceService.find(Integer.parseInt(idname));
		
		model.addAttribute("cargoResource", cargoResource);
		model.addAttribute("carsource", cl);
		return "views/layout/checkout";
	}

	/*
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "bookresource.do", method = RequestMethod.POST)
	public String postbookresource(int 	cid, int	rid ,Integer idname, Model model) {
		// JsonParameter
		
		//判断 车和货物是否在运输中
		Car car2 = carService.find(cid);
		CargoResource car = cargoResourceService.find(rid);
		
		
		
		
		UUID uuid = UUID.randomUUID(); // 实际项目中只有这句有用
		TrackOrder tOrder = new TrackOrder();
		tOrder.setCar(car2);
		tOrder.setcResource(car);
//		tOrder.setDriver(getUser());
//		tOrder.setOwner(car.get);
		tOrder.setUuid(uuid.toString());
		trackOrderService.save(tOrder);
		return "success";

	}
	
	@RequestMapping(value = "paying.do", method = RequestMethod.GET)
	public String paying(){

		return "views/layout/paying";
		

	}
	
	
	
//	  @RequestMapping(value="/{randomcode}/nani", method=RequestMethod.POST)
//	    public String dimList(Model model, String randomcode) {
//	        System.out.println("randomcode = " + randomcode);
//	        return "nani";
//	    }

}
