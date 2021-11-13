**Learning Dagger**

In this document, I try to explain the concept the Dependency Injection in Android with regards to 
using Dagger in Android applications, the core usages and workflow of different components in the 
Dagger Framework. I write this as I learn, so it's very possible that updates would keep coming in 
as I gather more information.

If you want to contribute to any of the enlisted explanations and illustrations, feel free to submit
a PR.

_Dependency Injection_
When we write classes, we write them with the "Single Responsibility Principle" in mind, as we
create classes around the exact things they need to do (to assist testing too). This not only allows
us to have lean classes, it also allows us separate concerns into smaller testable blocks when
writing software. The caveat here is for the main class (the main actor), other classes used in
execution would be more like **dependencies**, as the main class "depends" on them to perform its
executions.

For example, a repository class should not be concerned with making an API call directly, rather,
it offloads that responsibility to an APIHelper class who makes the requests and returns the
responses to the repository. It's safe to say that the Repository class "depends" on the APIHelper
class to make network requests.

Another example could be a class that helps activities and fragments instantiate dialogs, as
repeating the logic in these presentation classes could easily become cumbersome, so this dialog
class helps create and display dialogs in any presentational component that uses it.

Dependency Injection helps us separate the classes from being concerned with how
the objects used are being created, and it's possible in the following ways:
1. Constructor Injection: Passing dependencies via the class's constructor
2. Field Injection: Instantiating a field inside the class
3. Method Injection: Passing an object into the class's methods when required.

_Using Dagger_
Dagger is the official framework for setting up dependency injection in android application,
as it provides conventions and paradigms for developers around the world to follow so they can
write quality testable and maintainable code. The sections below explain different concepts in
Dagger and how they are used in the context of injecting dependencies from "outside".

_Modules_

_Components_

_Injections_

_Scopes_

_Dependencies_

_Subcomponents_

_Static Providers_

_Subcomponent Builders_

_Bindings (@BindsInstance and @Binds)_