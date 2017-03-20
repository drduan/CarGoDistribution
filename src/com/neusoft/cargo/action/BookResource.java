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
import com.neusoft.cargo.service.CargoResourceService;
import com.neusoft.cargo.service.TrackOrderService;
import com.neusoft.cargo.service.UserService;

@Controller("BookResourceAction")
public class BookResource extends Base {

	Logger logger = Logger.getLogger(BookResource.class);

	@Autowired
	// private CarService carservice;
	private UserService userservice;

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
	public String postbookresource(String 	cid,
		String	rid ,String idname, Model model) {
		// JsonParameter
		
		logger.error("message"+rid+cid);
//		List<Car> cl = userservice.GetCarList(getUser());
		UUID uuid = UUID.randomUUID(); // 实际项目中只有这句有用
//		CargoResource cargoResource = cargoResourceService.find(Integer.parseInt(idname));
//		model.addAttribute("cargoResource", cargoResource);
//		model.addAttribute("carsource", cl);
//		TrackOrder tOrder = new TrackOrder();
//		tOrder.setCar(car);
//		tOrder.setcResource(cResource);
//		tOrder.setUuid(uuid.toString());
//		trackOrderService.save(tOrder);
//		return "views/layout/checkout";
		return "success";

	}
	
	@RequestMapping(value = "paying.do", method = RequestMethod.GET)
	public String paying(){
//		String	rid ,String idname, Model model) {
		// JsonParameter
		
//		logger.error("message"+rid+cid);
//		List<Car> cl = userservice.GetCarList(getUser());
//		UUID uuid = UUID.randomUUID(); // 实际项目中只有这句有用
//		CargoResource cargoResource = cargoResourceService.find(Integer.parseInt(idname));
//		model.addAttribute("cargoResource", cargoResource);
//		model.addAttribute("carsource", cl);
//		TrackOrder tOrder = new TrackOrder();
//		tOrder.setCar(car);
//		tOrder.setcResource(cResource);
//		tOrder.setUuid(uuid.toString());
//		trackOrderService.save(tOrder);
//		return "views/layout/checkout";
		return "views/layout/paying";
		

	}
	
	
	
//	  @RequestMapping(value="/{randomcode}/nani", method=RequestMethod.POST)
//	    public String dimList(Model model, String randomcode) {
//	        System.out.println("randomcode = " + randomcode);
//	        return "nani";
//	    }

}
