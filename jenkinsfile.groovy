/*
* This groovy file calls  fuctions in another groovy file
* to improve mainainance 
*/
def gitUser = ''
def responderURL ='https://github.com/EdRincon/responder.git'

node {
	stage ('Clone second gith repository') {
		try{
			repoclone()
		} catch (Exception err){
			println err
		}
	}

	stage ('Use methods') {
		def responder = load 'responder.groovy'
		println responder
		responder.hello('hello')
	}
}

def repoclone() {
	checkout([$class: 'GitSCM', branches: [[name: '*/'+'master']], doGenerateSubmoduleConfigurations: false, extensions:
		[[$class: 'RelativeTargetDirectory'], [$class: 'MessageExclusion', excludeMessage: '(?s).*JENKINS_IGNORE.*']],
		submoduleCfg: [], userRemoteConfigs: [[url: "${responderURL}"]]])
	//git responderURL
}