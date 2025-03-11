{{- define "ticketing-service.name" -}}
ticketing-service
{{- end -}}

{{- define "ticketing-service.fullname" -}}
{{ include "ticketing-service.name" . }}-{{ .Release.Name }}
{{- end -}}
