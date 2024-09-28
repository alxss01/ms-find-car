# secret admin:
k get secret argocd-initial-admin-secret -o jsonpath={".data.password"} -n argocd | base64 -d

# Alterando contexto namespace do cluster
kubectl config set-context --current --namespace=argocd
:: Context "minikube" modified.

# Criando APP:
argocd app create ms-find-car --repo https://github.com/alxss01/ms-find-car.git --path k8s --dest-server https://kubernetes.default.svc --dest-namespace cars
