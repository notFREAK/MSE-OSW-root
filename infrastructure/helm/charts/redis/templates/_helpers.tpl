{{- define "redis.name" -}}
{{ .Chart.Name }}
{{- end -}}

{{- define "redis.fullname" -}}
{{ printf "%s-%s" .Release.Name .Chart.Name | trunc 63 | trimSuffix "-" }}
{{- end -}}