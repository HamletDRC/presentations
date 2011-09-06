import duby.lang.compiler.StringNode 


class Person  
    macro def make_attr(name, type) 
        quote do 
            def `name` 
                @`name` 
            end 
            def `name``"_set"`(`name`:`type`) 
                @`name` = `name` 
            end 
        end 
    end

    make_attr :name, :string 
end 


Person.new
