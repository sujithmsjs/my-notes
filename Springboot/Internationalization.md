https://reflectoring.io/spring-boot-internationalization/


Internationalization (i18n) 
Localization (l10n)

Culturally-dependent data: dates and currencies


Internationalization is most often a one-time process undertaken during the initial stages of design and development.

Internationalization is a mechanism to create multilingual software that can be adapted to different languages and regions.


LocaleResolver

resolve verb: to find an acceptable solution to a problem or difficulty.
resolve something to resolve an issue/a dispute/a conflict/a crisis

Localization is the process of adapting the internationalized application to a specific language and region by adding region-specific text and components.

Locale-specific components:
localizing the time and date differences, currency, culturally appropriate images, symbols, spelling, and other locale-specific components


Dialect: A particular form of a language which is peculiar to a specific region or social group.

locale-sensitive operations

Locale:
Represents a user's language, geographical region and any specific variant like dialect.

Locale to perform various kinds of locale-sensitive operations in the following sections using classes provided by Java as well as the helper classes like resolvers and interceptors in the Spring framework.

resolve something to resolve an issue/a dispute/a conflict/a crisis

Steps for Internationalization:

1. Resolving the user’s preferred locale from the incoming request from the user either in the form of a request parameter, cookies, or a request header.


2. Intercepting the change of locale in the incoming request and storing it in the user’s session or cookies.


3. Defining locale-specific resources, for example, language files for supported languages.


4. Mapping the region and language-sensitive elements in the view (HTML page, mobile app UI, etc) to elements capable of reading content at runtime based on the user’s language and region.


invariably
subsequent
resolving



LocaleResolver :
- interface
- 








































