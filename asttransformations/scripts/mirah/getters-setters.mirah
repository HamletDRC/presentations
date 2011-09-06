
class Person  
    macro def make_attr(name, type) 
        attribute_name = name.string_value()
        quote {
            def `name` 
                @`name` 
            end 
            def `"#{attribute_name}_set"`(value:`type`) 
                @`name` = value
            end 
        }
    end

    make_attr :firstName, :string 
end 


p = Person.new
p.firstName = 'hamlet'
puts p.firstName
