Java has some guidelines/rules which are followed in development, some of them are bydefault imposed as part of java rules
1. Signature rule
2. Property rule
3. Method rule


1. Signature rule:
    I. Method Argument Rule: 
    If there is a Parent class with method solve(String s) then when child class is overriding same method then it should use same type of parameter like Child can have same solve(String s) (this is by default imposed by java as rule and gives error when changed).

    Ex:
        class Parent{
            public void solve(String s){}
        }

        class Child extends Parent{
            @Override
            public void solve(String s){}
        }

    II. Return Type Rule:
    If there is a Parent class which has a method random() and return Animal Object then If Child is overriding the same method then return type should be either same or child of that return object

    Ex:
        class Parent{
            public Animal random(String s){
                return new Animal();
            }
        }

        class Child extends Parent{

            Either->
            @Override
            public Animal random(String s){
                return new Animal();
            }

            or->
            @Override
            public Dog random(String s){ Doing this is called coveriance
                return new Dog();
            }

            here Dog is child of Animal
        }
    
    III. Exception Rule:
    If parent throws Exception B then child should either throw same Exception or parent of that Exception
    here we can assume A is parent exception of B then child can throw any on them but not child of B because it should always use broader of parent

    Ex:
        class Parent{
            public void solve(String s){
                throws new runtimeException()
            }
        }

        class Child extends Parent{

            either->
            @Override
            public void solve(String s){
                 throws new runtimeException()
            }

            or parent of runtimeException is Exception->
            @Override
            public void solve(String s){
                 throws new Exception()
            }
        }

2. Property rule:
    Invariant means a property or a rule which a class follow
    I. Class Invariant:
        Child class can either maintain or stregthen the invariant but never narrows it down.
        Suppose we have a class Account which has a property balance, where it says balance can never be negative, but if there is another child class which makes it negative then it breaks the invariant rule (Here invariant is - Balance can not be negative)

    II. History Contraint:
        If a parent class Account has a method withdraw() and it says that child must use it, but there is a child like FDAccount which don't use it then it breaks the history contraint rule.

        If there is immutable methods or variable in a class but child makes it mutable then there also history contraint rule is breaking.

3. Method rule:
    I. Pre-condition:
        Suppose we have a class and there in method or variable we have written some pre conditions, but if child override it and does not follow the pre-condition then it breaks the rule. (we can make these condition weak in child but should not stregthen it)

        EX: If a User class has method password() where it has written pre-condition in comment that pwd length should be greater than 8
            Now if a child uses same method and uses pre-condition correctly then it is good, or else child can have logic where pwd length could be greater that 6, this also works because it is still passing parent class pre-condition but if child make it length 1 to 7 then it breaks.
    
    II. Post-condition:
        it is opposite of pre-condition
        suppose if class car has a method break() which says after running this method break should be applied then child should also do the same thing, child can add more functionality on it but it should follow the post-conditiona as well.