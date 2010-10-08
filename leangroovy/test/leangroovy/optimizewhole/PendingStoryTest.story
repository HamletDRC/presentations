package leangroovy.optimizewhole


scenario "Existing user should be able to manage account", {
    given "a valid user"
    and "a valid password"
    then "the user should be able to update their name"
    and "and update their address"
}