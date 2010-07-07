class BootStrap {

     def init = { servletContext ->
	
			new Person(name:'Scott Vlaminck', dateOfBirth:new Date(1977,1,1)).save()
			new Person(name:'Steve Vlaminck', dateOfBirth:new Date(1983,1,1)).save()
			new Person(name:'Scott Wilson', dateOfBirth:new Date(1981,1,1)).save()
     }
     def destroy = {
     }
} 