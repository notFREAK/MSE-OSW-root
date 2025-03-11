{{- define "gateway-service.name" -}}
gateway-service
{{- end -}}

{{- define "gateway-service.fullname" -}}
{{ include "gateway-service.name" . }}-{{ .Release.Name }}
{{- end -}}
