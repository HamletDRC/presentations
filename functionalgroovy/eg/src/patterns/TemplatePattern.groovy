package patterns

static def step1(input) { input }
static def step3(input) { input }

static def template(input, step2) {
    def x = step1(input)
    def y = step2(x)
    step3(y)
}

abstract class Template {
    def template(input) {
        def x = step1(input)
        def y = step2(x)
        step3(y)
    }
    def step1(input) {
        input
    }
    protected abstract step2(input)
    def step3(input) {
        input
    }
}
class TemplateImpl extends Template {
    def step2(input) {
        input
    }
}

assert 5 == new TemplateImpl().template(5)

def templateImpl = {input -> template(input, { it }) }
assert 5 == templateImpl(5)