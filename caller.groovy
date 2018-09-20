/*
* This groovy file calls  fuctions in another groovy file
* to improve mainainance 
*/
def gitUser = ''
def responderURL ='https://github.com/EdRincon/responder.git'

node {master} {
	stage ('Clone second gith repository') {
		try{
			git responderURL
		} catch (Exception err){
			println err
		}
	}

	stage ('Use methods') {
		def responder = load 'responder.groovy'
		responder.hello('hello')
	}
}

//def checkout() {
//	checkout([$class: 'GitSCM', branches: [[name: '*/'+"${master}"]], doGenerateSubmoduleConfigurations: false, extensions:
//		[[$class: 'RelativeTargetDirectory'], [$class: 'MessageExclusion', excludeMessage: '(?s).*JENKINS_IGNORE.*']],
//		submoduleCfg: [], userRemoteConfigs: [[credentialsId: "${credentialsId}", url: "${responderURL}"]]])
//}