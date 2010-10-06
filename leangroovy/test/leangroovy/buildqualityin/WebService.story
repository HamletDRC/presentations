package leangroovy.buildqualityin

using "xmlunit"

scenario "web service should return XML based users", {
    given "a user web service", {
        service = new UserWebService()
    }
    when "a user is looked up in the web service", {
        webServiceResult = service.get(123456)
    }
    then "the user's record should be found", {
        webServiceResult.shouldBeIdenticalTo """
			<user id="123456">
				<firstname>John</firstname>
				<lastname>Doe</lastname>
			</user>"""
    }
}