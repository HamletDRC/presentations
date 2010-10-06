package leangroovy.buildqualityin

class UserWebService {

    def get(parm) {
        """
			<user id="123456">
				<firstname>John</firstname>
				<lastname>Doe</lastname>
			</user>"""
    }
}
