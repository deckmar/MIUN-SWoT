package com.miun.sensors;



import java.util.StringTokenizer;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/tags")
public class TagController {
	
	@Resource(name="tagService")
	private TagService tagService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public TagList get() {
		TagList tags = tagService.getAll();
		return tags;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity put(@RequestBody Tag tag) {
		tagService.update(tag);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String getTag(@PathVariable long id) {
		Tag tag = tagService.get(id);
		if(tag != null){
			return tag.getTemp();
		}
		return "Invalid sensor id";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity putTag(@PathVariable long id, @RequestBody String body) {
		StringTokenizer parseBody = new StringTokenizer(body, "=");
		String key = parseBody.nextToken();
		String value = parseBody.nextToken();
		Tag t = new Tag();
		t.setId(id);
		t.setTemp(value);
		tagService.update(t);
		return new ResponseEntity(HttpStatus.OK);
	}
}
