package lambdajavasprintgdp.ecogdp.controllers;

import lambdajavasprintgdp.ecogdp.EcoGdpApplication;
import lambdajavasprintgdp.ecogdp.GDPList;
import lambdajavasprintgdp.ecogdp.exception.ResourceNotFoundException;
import lambdajavasprintgdp.ecogdp.models.GDP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Comparator;

import static lambdajavasprintgdp.ecogdp.EcoGdpApplication.ourGDPList;

@RestController
@RequestMapping("/countries")
public class GDPController
{
	private static Logger logger = LoggerFactory.getLogger(GDP.class);

	//localhost:8080/countries/names
	@GetMapping(value = "/names", produces = {"application/json"})
	public ResponseEntity<?> allCountryNames()
	{
		ArrayList<GDP> sortedGDPList = ourGDPList.gdpList;
		sortedGDPList.sort((g1, g2) -> g1.getName().compareToIgnoreCase(g2.getName()));

		logger.info("/names accessed");

		return new ResponseEntity<>(sortedGDPList, HttpStatus.OK);
	}

	//localhost:8080/countries/economy
	@GetMapping(value = "economy", produces = {"application/json"})
	public ResponseEntity<?> sortedCountryGDPs()
	{
		ArrayList<GDP> sortedGDPList = ourGDPList.gdpList;
		sortedGDPList.sort((g1, g2) -> (int)g1.getGdp() - (int)g2.getGdp());

		logger.info("/economy accessed");
		return new ResponseEntity<>(sortedGDPList, HttpStatus.OK);
	}

	//localhost:8080/countries/gdp/{countryname}
	@GetMapping(value = "gdp/{countryName}", produces = {"application/json"})
	public ResponseEntity<?> getCountryGDP(@PathVariable String countryName)
	{
		GDP rtnGDP;

		if ((ourGDPList.findGDP(c -> c.getName().toLowerCase().equals(countryName.toLowerCase()))) == null)
		{
			throw new ResourceNotFoundException("Country " + countryName +  " not found");
		} else {
			rtnGDP = ourGDPList.findGDP(c -> c.getName().toLowerCase().equals(countryName.toLowerCase()));
			logger.info("/economy accessed");
		}

		return new ResponseEntity<>(rtnGDP, HttpStatus.OK);
	}

	//localhost:8080/countries/country/{id}
	@GetMapping(value = "country/{id}", produces = {"application/json"})
	public ResponseEntity getCountryById(@PathVariable long id)
	{
		GDP rtnCountry;
		if ((ourGDPList.findGDP(d -> (d.getId()) == id)) == null)
		{
			throw new ResourceNotFoundException("Country with id " + id + " not found");
		} else {
			rtnCountry = ourGDPList.findGDP(d -> (d.getId() == id));
			logger.info("/country/id hit");
		}

		return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
	}

	//localhost:8080/countries/country/stats/median
	@GetMapping(value = "country/stats/median", produces = {"application/json"})
	public ResponseEntity<?> medianGDPCountry()
	{
		GDPList sortedGDPList = new GDPList();
		Comparator<GDP> cmp = new Comparator<>()
		{
			@Override
			public int compare(GDP o1, GDP o2)
			{
				return (int)o1.getGdp() - (int)o2.getGdp();
			}
		};
		sortedGDPList.gdpList.sort((g1, g2) -> cmp.compare(g1, g2) );
		GDP rtnCountry = (sortedGDPList.gdpList.get(sortedGDPList.gdpList.size() / 2));
		logger.info("/country/stats/median accessed");
		return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
	}

	//localhost:8080/countries/economy/greatest/{gpd}
	@GetMapping(value = "economy/greatest/{gdp}", produces = {"application/json"})
	public ModelAndView displayCountryIfGDPGreaterThan(@PathVariable int gdp)
	{
		ArrayList<GDP> greaterThanGivenGDP;

		greaterThanGivenGDP = EcoGdpApplication.ourGDPList.findGDPs(g -> g.getGdp() >= gdp);
		greaterThanGivenGDP.sort((e1, e2) -> (int)e2.getGdp() - (int)e1.getGdp());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("gpdDisplay");
		mav.addObject("countryList", greaterThanGivenGDP);

		return mav;
	}

	//localhost:8080/countries/economy/table
	@GetMapping(value = "economy/table", produces = {"application/json"})
	public ModelAndView displayAllGDPs()
	{
		ArrayList<GDP> allCountries;
		allCountries = ourGDPList.gdpList;
		allCountries.sort((e1, e2) -> (int)e2.getGdp() - (int)e1.getGdp());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("gpdDisplay");
		mav.addObject("countryList", allCountries);

		return mav;
	}
}
