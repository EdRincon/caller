/*
* This groovy file calls  fuctions in another groovy file
* to improve mainainance 
*/
def gitUser = ''

node {
	stage ('Clone second gith repository') {
		try{
			repoclone()
			def responder 
			println responder
			responder = load 'responder.groovy'
			println responder
			responder.hello('hello')
		} catch (Exception err){
			println err
		}
	}
}

def repoclone() {
	checkout([$class: 'GitSCM', branches: [[name: '*/'+'master']], doGenerateSubmoduleConfigurations: false, extensions:
		[[$class: 'RelativeTargetDirectory'], [$class: 'MessageExclusion', excludeMessage: '(?s).*JENKINS_IGNORE.*']],
		submoduleCfg: [], userRemoteConfigs: [[url: "https://github.com/EdRincon/responder.git"]]])
	//git responderURL
}