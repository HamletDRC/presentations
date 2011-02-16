package com.canoo.cdi;

import com.canoo.cdi.interceptors.Transactional;

public interface IGreeter {
    @Transactional
    void sayHello(String name);
}
