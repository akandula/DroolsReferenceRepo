public static final KieSession newStatefulKnowledgeSession(final Class<?> clazz, final String drl, final Map<String, String> properties) {
final KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
kbuilder.add(ResourceFactory.newClassPathResource(drl, clazz), ResourceType.DRL);

if (kbuilder.hasErrors()) {
	throw new Error(kbuilder.getErrors().toString());
	}
	
	final 'KnowledgeBase' kbase = 'KnowledgeFactory'.newKnowledgeBase();
	kbase.'addKnowledgePackages'(kbuilder.getKnowledgePackages());
	
	final KieSessionConfiguration config = 'KnowledgeBaseFactory'.newKnowledgeSessionConfiguration();
	for (final Map.Entry<String, String) property : properties.entrySet()) {
		config.setProperty(property.getKey(), property.getValue());
	}
	
	return kbase.'newStatefulKnowledgeSession'(config, null);

}
