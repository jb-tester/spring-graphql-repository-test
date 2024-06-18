https://youtrack.jetbrains.com/issue/IDEA-335703 :
actually the methods defined in the repository:

are shown as unused
no navigation/completion to/from schema queries are provided
don't appear in the Endpoints view
there is no possibility to generate the GraphQL request for these queries

https://youtrack.jetbrains.com/issue/IDEA-335700 :
for the @GraphQlRepository -annotated class the navigation to the graphql schema could be provided:
if no #typeName is provided, the short name of the repository domain type is used to match to the schema type.

https://youtrack.jetbrains.com/issue/IDEA-335701 :
provide completion/navigation for the typeName attribute of the @GraphQlRepository annotation



GraphQL Tests:

https://youtrack.jetbrains.com/issue/IDEA-335822
GraphQlTester: inject JsonPath into path(String path)

https://youtrack.jetbrains.com/issue/IDEA-335820
GraphQlTester: inject GraphQL into documentString

https://youtrack.jetbrains.com/issue/IDEA-335821
GraphQlTester: inject reference to file into documentNameString documentName



- 