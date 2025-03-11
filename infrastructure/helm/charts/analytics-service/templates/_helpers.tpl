{{- define "analytics-service.name" -}}
analytics-service
{{- end -}}

{{- define "analytics-service.fullname" -}}
{{ include "analytics-service.name" . }}-{{ .Release.Name }}
{{- end -}}
